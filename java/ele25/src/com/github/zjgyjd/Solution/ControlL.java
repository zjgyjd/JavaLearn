package com.github.zjgyjd.Solution;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlL {
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
                while (true){
                    rb.mouseMove((int) p.getX(), (int) p.getY());
                    rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    rb.delay(200);
                    rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    for (int i = 0; i < 5; i++) {
                        rb.delay(1000);
                    }
                    rb.mouseMove(1068,314);
                    rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                    rb.delay(200);
                    rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                    for (int i = 0; i < 10; i++) {
                        rb.delay(1000);
                    }
                }
            }

        }).start();
    }
}
