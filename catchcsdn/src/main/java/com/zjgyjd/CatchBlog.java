package com.zjgyjd;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class CatchBlog implements PageProcessor {
    private static String username = "qq598535550";
    private static int size = 0; //文章数
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        if (!page.getUrl().regex("http://blog\\.csdn\\.net/" + username + "/article/details/\\d+").match()) {
            // 添加所有文章页
            page.addTargetRequests(page.getHtml().xpath("//div[@class='article-list']").links()// 限定文章列表获取区域
                    .regex("/" + username + "/article/details/\\d+")
                    .replace("/" + username + "/", "http://blog.csdn.net/" + username + "/")// 巧用替换给把相对url转换成绝对url
                    .all());
            // 添加其他列表页
            page.addTargetRequests(page.getHtml().xpath("//div[@id='papelist']").links()// 限定其他列表页获取区域
                    .regex("/" + username + "/article/list/\\d+")
                    .replace("/" + username + "/", "http://blog.csdn.net/" + username + "/")// 巧用替换给把相对url转换成绝对url
                    .all());
            // 文章页
        } else {
            size++;// 文章数量加1
            // 用CsdnBlog类来存抓取到的数据，方便存入数据库
            CsdnBlog csdnBlog = new CsdnBlog();

            // 设置编号(可用)
            csdnBlog.setId(Integer.parseInt(
                    page.getUrl().regex("http://blog\\.csdn\\.net/" + username + "/article/details/(\\d+)").get()));


            // 设置标题(可用)
            csdnBlog.setTitle(
                    page.getHtml().xpath("//h1[@class='title-article']/text()").get());
            // 设置日期(可用)
            csdnBlog.setDate(
                    page.getHtml().xpath("//div[@class='article-bar-top']/span[@class='time']/text()").get());

            // 设置阅读人数(可用)
            String readNum = page.getHtml().xpath("//div[@class='article-bar-top']/span[@class='read-count']/text()")
                    .get();
            //提取出来为 阅读数: (//d+) 进行拆分转化为int
            csdnBlog.setView(Integer.parseInt(readNum.substring(readNum.indexOf("数") + 2)));

            // 设置是否原创
            csdnBlog.setCopyright(page.getHtml()
                    .xpath("//div[@class='article-title-box']/span[@class='article-type']/text()").get());

           // 把对象存入数据库
           new CsdnBlogDB().add(csdnBlog);
           // 把对象输出控制台
            System.out.println(csdnBlog);
        }
    }

    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("【爬虫开始】请耐心等待一大波数据到你碗里来...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CatchBlog()).addUrl("http://blog.csdn.net/" + username).thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共抓取" + size + "篇文章，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");
    }


}
