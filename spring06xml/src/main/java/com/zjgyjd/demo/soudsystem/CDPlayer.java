package com.zjgyjd.demo.soudsystem;

public class CDPlayer {
    private CompactDisc cd;

    public CDPlayer(){
        super();
        System.out.println("CDPlayer构造函数");
    }

    public CDPlayer(CompactDisc cd){
        this.cd = cd;
        System.out.println("CDPlayer的有参构造函数" + this.toString());
    }

    public void play(){
        System.out.println("CDPlayer : " + this.toString());
        cd.play();
    }
}

