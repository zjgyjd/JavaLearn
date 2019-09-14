package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Power {
    public Power() {
        super();
    }

    public void supply(){
        System.out.println("供电中>>>>>>>>");
    }
}
