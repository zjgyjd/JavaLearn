package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//加载Spring环境
@ContextConfiguration(classes = AppConfig.class)//加载Spring容器,帮助省略
// ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
public class AppTest {
    @Autowired
    private CDPlayer player;
    @Test
    public void testPlay() {
        player.play();
    }
}
