package com.github.zjgyjd.generic;

import java.io.ObjectOutputStream;

public class Point {
    private Object x;
    private Object y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Object getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
