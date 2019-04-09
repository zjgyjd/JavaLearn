package com.github.zjgyjd.generic;

public class Point1<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public Point1(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        //Point1---> Integer
        Point1<Integer> point1 = new Point1<>(10,20);//1.7之后不需要在后面尖括号写类型
        int x = point1.getX();
        int y = point1.getY();
        System.out.println("("+x+","+y+")");
    }
}
