package com.gihub;

import org.apache.commons.collections.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * 缺点:当发布时间一样时,两个视频的顺序不定,需要手动选择
 */
public class CatchXigua implements PageProcessor {
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("UTF-8");
    private static final String LIST_URL = "https://www\\.ixigua\\.com/c/user/article/\\?user_id.*";
    private static List<String> list;
    private String userId = null;
    private String name = null;
    private File temp = null;

    public void setTemp() {
        this.temp = Paths.get("D:", this.getName() + ".txt").toFile();
        if (!temp.exists()) {
            try {
                temp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter fileWriter = new FileWriter(temp)) {
            fileWriter.write("----------------------------------------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private int num = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private void setNum(int num) {
        this.num = num;
    }

    @Override
    public Site getSite() {
        return site;
    }

    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    @Override
    public void process(Page page) {
        if (num != 0) {
            System.out.println("正在匹配");
            if (page.getUrl().regex(LIST_URL).match()) {
                System.out.println("匹配成功");
                List<String> ids = new JsonPathSelector("$.data[*].item_id")
                        .selectList(page.getRawText());
                List<String> time = new JsonPathSelector("$.data[*].behot_time").selectList(page.getRawText());
                if (CollectionUtils.isNotEmpty(ids) && CollectionUtils.isNotEmpty(time)) {
                    //创造键值进行排序
                    LinkedHashMap<String, Long> users = this.sortUser(ids, time);
                    System.out.println("正在排序");
                    //通过id,创造链接
                    for (Map.Entry<String, Long> entry : users.entrySet()) {
//                    System.out.println(entry.getKey()+"  "+entry.getValue());
                        page.addTargetRequest
                                ("https://www.ixigua.com/i"
                                        + entry.getKey() + "/#mid=" + this.getUserId());
                    }
                }

            } else {

                this.putURL(page.getUrl().toString(), page.getHtml().xpath("//title/text()").get(), temp);
            }
        }
    }

    private LinkedHashMap<String, Long> sortUser(List<String> ids, List<String> time) {
        LinkedHashMap<String, Long> temp = new LinkedHashMap<>();
        //存储
        for (int i = 0; i < ids.size(); i++) {
            temp.put(ids.get(i), Long.valueOf(time.get(i)));

        }
        //排序
        List<Map.Entry<String, Long>> list = new ArrayList<>(temp.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (o1.getValue().compareTo(o2.getValue())) * -1;
            }
        });

        //重新构造
        temp.clear();
        for (Map.Entry<String, Long> item : list
        ) {
            temp.put(item.getKey(), item.getValue());
            this.num--;
            if (num == 0) {
                break;
            }
        }
        for (Map.Entry<String, Long> item : temp.entrySet()) {
            System.out.println(item.getKey() + "  " + item.getValue());
        }
        return temp;
    }


    private void putURL(String url, String title, File f) {
        try (FileWriter f1 = new FileWriter(f, true)) {
            String temp = "标题:" + title + " 链接:" + url + "\n";
            f1.write(temp);
        } catch (Exception e) {
            System.out.println("文件保存有误");
        }
    }

    public static void main(String[] args) {
        File x = Paths.get("D:", "userName.txt").toFile();
        //显示所有用户名以及编号
        CatchXigua catchs = new CatchXigua();
        List<User> users = User.createObjct(x);
        Scanner scanner = new Scanner(System.in);
        //循环打印
        while (true) {
            int choose = catchs.printName(users);
            while (choose > users.size()) {
                System.out.println("输入有误,,请重新输入");
                choose = catchs.printName(users);
            }
            if (choose == 0) {
                break;
            }
            //取出id,并选择爬去视频数量
            User target = users.get(choose - 1);
            catchs.setName(target.getName());
            System.out.println("您的选择是:" + catchs.getName() + " ,请选择需要视频量");
            int num = scanner.nextInt();
            catchs.setNum(num);
            catchs.setUserId(target.getId());
            System.out.println("ID: " + target.getId());
            catchs.setTemp();
            Spider.create(catchs).addUrl("https://www.ixigua.com/c/user/article/?user_id=" + catchs.getUserId() + "&max_behot_time=0&max_repin_time=0&count=20&page_type=0")
                    .thread(1).run();
        }
    }

    private int printName(List<User> users) {
        Scanner scanner = new Scanner(System.in);
        int size = users.size();
        int add = 0;
        System.out.println("---------------------------------------------------------");
        while (size != 0) {
            System.out.println(users.get(add).getName() + " 编号:" + (add + 1));
            add++;
            size--;
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("请选择一个编号:(只选一个选0则退出)");
        return scanner.nextInt();
    }

}
