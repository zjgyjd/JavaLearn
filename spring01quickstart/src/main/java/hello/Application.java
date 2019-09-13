package hello;

public class Application {
    public static void main(String[] args) {
        System.out.println("application");
        MessagePrinter printer = new MessagePrinter();
        //MessageService service = new MessageService();//交给Spring
        //设置打印机对象的service
        //printer.setService(service);//交给Spring
        //打印消息
        printer.printMessage();
    }
}
