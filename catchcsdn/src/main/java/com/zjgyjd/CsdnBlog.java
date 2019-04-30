package com.zjgyjd;

public class CsdnBlog {
    private int id;// 编号

    private String title;// 标题

    private String date;// 日期

    private int view;// 阅读人数

    private String copyright;// 是否原创

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }


    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String  copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "CsdnBlog [id=" + id + ", title=" + title + ", date=" + date + ", view=" + view + ", copyright=" + copyright + "]";
    }

}
