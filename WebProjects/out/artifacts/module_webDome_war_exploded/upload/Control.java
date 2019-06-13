import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;

public class Control {
    public static void main(String[] args) throws AWTException {
        Robot rb = new Robot();
        Date date = new Date();
        Point p = MouseInfo.getPointerInfo().getLocation();
        System.out.println((int) p.getX() + "  " + (int) p.getY());

        while (true) {
            Point x = MouseInfo.getPointerInfo().getLocation();
            rb.delay(500);
            rb.mouseMove((int) p.getX(), (int) p.getY());
            rb.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            rb.delay(20);
            rb.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
         
            for (int i = 0; i < 1; i++) {
                rb.delay(6000);
            }
        }
    }
}
