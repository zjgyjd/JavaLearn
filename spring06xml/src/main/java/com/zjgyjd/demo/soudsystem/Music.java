package com.zjgyjd.demo.soudsystem;

public class Music {
    private String title;
    private Integer duration;

    public Music() {
        super();
    }

    public Music(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
