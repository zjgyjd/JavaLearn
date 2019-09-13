package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ApplicationSpring {
    public static void main(String[] args) {
        System.out.println("applicationSpring");
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationSpring.class);
        //从容器中获取MessagePrint
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        MessageService service = context.getBean(MessageService.class);
        printer.setService(service);
        //打印消息
        printer.printMessage();
    }
}
