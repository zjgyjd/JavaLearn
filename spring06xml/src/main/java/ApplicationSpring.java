import com.zjgyjd.demo.soudsystem.CompactDisc;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationSpring {
    public static void main(String[] args) {
        System.out.println("Application is running.....");
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();
    }
}
