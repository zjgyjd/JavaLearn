package controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import domain.Account;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("初级参数绑定 "+ username);
        return "success";
    }
    @RequestMapping("/save")
    public String saveAccount(Account account){
        System.out.println("JavaBean参数绑定: "+ account);
        return "success";
    }
    @RequestMapping("/saveUser")
    public String saveAccount(User user){
        System.out.println("自定义类型转换: "+ user);
        return "success";
    }
}
