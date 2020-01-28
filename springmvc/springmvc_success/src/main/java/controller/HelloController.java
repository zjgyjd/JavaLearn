package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//控制器类
@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("mvcStart");
        return "success";
    }

    @RequestMapping("/test")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解....");
        return "success";
    }
}
