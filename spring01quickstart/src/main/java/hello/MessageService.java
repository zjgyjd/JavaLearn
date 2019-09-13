package hello;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    public static void main(String[] args) {

    }

    public MessageService() {
        super();
        System.out.println("MessageService");
    }


    public String getMessage(){
        return "Hello World";
    }
}
