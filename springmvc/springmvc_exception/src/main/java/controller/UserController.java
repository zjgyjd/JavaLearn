package controller;

import exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception {
        System.out.println("testException执行了....");
        //模拟异常
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出异常信息
            throw new SysException("查询所有用户出现错误.....");
        }
        return "success";
    }
}
