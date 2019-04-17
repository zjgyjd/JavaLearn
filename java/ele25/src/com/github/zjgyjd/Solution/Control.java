package com.github.zjgyjd.Solution;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Control {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Robot rb = null;
                try {
                    rb = new Robot();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                Point p = MouseInfo.getPointerInfo().getLocation();
                System.out.println((int) p.getX() + "  " + (int) p.getY());
                int k = 10;
                while (true) {

                    Point x = MouseInfo.getPointerInfo().getLocation();

                    while (k > 0) {
                        rb.mouseMove((int) p.getX(), (int) p.getY());
                        k--;
                    }

                    rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    rb.delay(200);
                    rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    while (k < 10) {
                        rb.mouseMove((int) x.getX(), (int) x.getY());
                        k++;
                    }
                    rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    rb.delay(200);
                    rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(df.format(System.currentTimeMillis()));
                    for (int i = 0; i < 1; i++) {
                        rb.delay(6000);
                    }
                    System.out.println(df.format(System.currentTimeMillis()));
                }
            }
        }).start();


    }
}
