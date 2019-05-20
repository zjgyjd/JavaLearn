package com.github.zjgyjd.Solution;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ControlV {
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
                assert rb != null;
                //YH
                rb.mouseMove(628,420);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(200);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                rb.keyPress(KeyEvent.VK_Y);
                rb.keyRelease(KeyEvent.VK_Y);
                rb.keyPress(KeyEvent.VK_H);
                rb.keyRelease(KeyEvent.VK_H);
                rb.keyPress(KeyEvent.VK_SPACE);
                rb.keyRelease(KeyEvent.VK_SPACE);


                //移动
                rb.mouseMove(579,455);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(200);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

                //身份证
                rb.mouseMove(621,564);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(200);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                rb.keyPress(KeyEvent.VK_5);
                rb.keyRelease(KeyEvent.VK_5);

                rb.keyPress(KeyEvent.VK_3);
                rb.keyRelease(KeyEvent.VK_3);

                rb.keyPress(KeyEvent.VK_2);
                rb.keyRelease(KeyEvent.VK_2);

                rb.keyPress(KeyEvent.VK_3);
                rb.keyRelease(KeyEvent.VK_3);

                rb.keyPress(KeyEvent.VK_0);
                rb.keyRelease(KeyEvent.VK_0);

                rb.keyPress(KeyEvent.VK_1);
                rb.keyRelease(KeyEvent.VK_1);

                rb.keyPress(KeyEvent.VK_1);
                rb.keyRelease(KeyEvent.VK_1);

                rb.keyPress(KeyEvent.VK_9);
                rb.keyRelease(KeyEvent.VK_9);

                rb.keyPress(KeyEvent.VK_9);
                rb.keyRelease(KeyEvent.VK_9);

                rb.keyPress(KeyEvent.VK_9);
                rb.keyRelease(KeyEvent.VK_9);

                rb.keyPress(KeyEvent.VK_0);
                rb.keyRelease(KeyEvent.VK_0);

                rb.keyPress(KeyEvent.VK_1);
                rb.keyRelease(KeyEvent.VK_1);

                rb.keyPress(KeyEvent.VK_2);
                rb.keyRelease(KeyEvent.VK_2);

                rb.keyPress(KeyEvent.VK_7);
                rb.keyRelease(KeyEvent.VK_7);

                rb.keyPress(KeyEvent.VK_0);
                rb.keyRelease(KeyEvent.VK_0);

                rb.keyPress(KeyEvent.VK_0);
                rb.keyRelease(KeyEvent.VK_0);

                rb.keyPress(KeyEvent.VK_3);
                rb.keyRelease(KeyEvent.VK_3);

                rb.keyPress(KeyEvent.VK_2);
                rb.keyRelease(KeyEvent.VK_2);

                //类别
                rb.mouseMove(699, 616);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(200);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

                rb.mouseMove(594, 662);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(500);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

                rb.delay(500);
                rb.mouseMove(594,655);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(500);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

                rb.mouseMove(594,690);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(500);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

                //西安工业大学
                rb.mouseMove(595, 684);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(200);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
                rb.keyPress(KeyEvent.VK_X);
                rb.keyRelease(KeyEvent.VK_X);
                rb.keyPress(KeyEvent.VK_A);
                rb.keyRelease(KeyEvent.VK_A);
                rb.keyPress(KeyEvent.VK_G);
                rb.keyRelease(KeyEvent.VK_G);
                rb.keyPress(KeyEvent.VK_Y);
                rb.keyRelease(KeyEvent.VK_Y);
                rb.keyPress(KeyEvent.VK_D);
                rb.keyRelease(KeyEvent.VK_D);
                rb.keyPress(KeyEvent.VK_X);
                rb.keyRelease(KeyEvent.VK_X);
                rb.keyPress(KeyEvent.VK_SPACE);
                rb.keyRelease(KeyEvent.VK_SPACE);

                //移动
                Point p = MouseInfo.getPointerInfo().getLocation();
                System.out.println((int) p.getX() + "  " + (int) p.getY());// 1358 201
                rb.mouseMove(1358,486);
                rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
                rb.delay(200);
                rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            }
        }).start();
    }
}
