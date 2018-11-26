package com.github.zjgyjd;


public class OnOffSwitch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }
    public void off(){
        state = false;
        System.out.println(this);
    }
}
