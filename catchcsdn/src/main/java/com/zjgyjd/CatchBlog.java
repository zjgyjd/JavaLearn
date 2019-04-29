package com.zjgyjd;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class CatchBlog implements PageProcessor {
    private String userName = "zjgyjd";
    private int size = 0; //文章数
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }


}
