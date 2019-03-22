package com.github.zjgyjd.onechase;

public class Chase {
    public static void main(String[] args) {
        Thief thief = new Thief();
        Police police = new Police();
        Game start = new Game(police,thief);
        start.start();
    }
}
