package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
    @Autowired(required = false)
    private CompactDisc cd;

    @Autowired
    private Power power;

//    @Autowired
//    public void setCd(CompactDisc cd) {
//        this.cd = cd;
//        System.out.println("调用setCd");
//    }
//    @Autowired
//    public void setPower(Power power) {
//        this.power = power;
//        System.out.println("调用setPower");
//    }

    public CDPlayer() {
        super();
        System.out.println("CDPlayer无参构造函数");
    }

    //    @Autowired
//    public CDPlayer(CompactDisc cd){
//        this.cd = cd;
//        System.out.println("CDPlayer的有参构造函数");
//    }
//    @Autowired
//    public CDPlayer(CompactDisc cd, Power power) {
//        this.cd = cd;
//        this.power = power;
//        System.out.println("CDPlayer的多参构造函数");
//    }
    public void play() {
        power.supply();
        if (cd != null) {
            cd.play();//设置了@Autowired关键字中的required属性为false,
            // 表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错
        }
    }
}
