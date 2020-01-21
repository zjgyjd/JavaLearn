package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model mode1) {
        System.out.println("执行了..");
        //模拟从数据库中查询User
        User user = new User();
        user.setUsername("sandy");
        user.setPassword("123");
        user.setAge(20);
        //model对象
        mode1.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了..");
        //编写请求转发
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request , response);
        //编写重定向
        // response.sendRedirect(request.getContextPath() + "/index.jsp");
        //直接会进行响应
        response.getWriter().print("hello");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建一个ModelAndView
        ModelAndView mv = new ModelAndView();
        System.out.println("执行了..");
        //模拟从数据库中查询User
        User user = new User();
        user.setUsername("sandy");
        user.setPassword("123");
        user.setAge(20);
        //通过key 和 value存储对象
        mv.addObject("user", user);
        //指定跳转到那个页面
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        //利用关键字触发转发和重定向
        System.out.println("执行了...");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";

        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("执行了...");
        //此时客户端发送ajax请求,传的是json字符串,后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应,模拟查询的数据库
        user.setUsername("lucky");
        user.setAge(21);
        //做响应
        return user;
    }
}
