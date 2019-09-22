package com.zjgyjd.demo.soudsystem;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompactDisc {
    private String title;
    private String artist;
    private int num;
    private Music[] tracks;

    public CompactDisc(String title, String artist, int num,Music[] tracks) {
        this.title = title;
        this.artist = artist;
        this.num = num;
        this.tracks = tracks;
        System.out.println("CompactDisc有四个参数的构造方法");
    }

    public CompactDisc() {
        super();
        System.out.println("CompactDisc构造函数,...." + this.toString());
    }

    public void play() {
        System.out.println("播放音乐>>>>>>>>>" + this.toString() + " " + this.title + " by " + this.artist + " " +
                this.num + "人已听");
        for (Music track : this.tracks) {
            System.out.println("音乐: " + track.getTitle() + ",时长: " + track.getDuration());
        }
//        for (String key: this.tracks.keySet()){
//            System.out.println("key: " + key);
//            Music music = this.tracks.get(key);
//            System.out.println("音乐: " + music.getTitle() + ",时长: " + music.getDuration());
//        }
    }

    public CompactDisc(String title, String artist, int num) {
        this.title = title;
        this.artist = artist;
        this.num = num;
        System.out.println("CompactDisc有参构造函数,...." + this.toString());
    }
}
