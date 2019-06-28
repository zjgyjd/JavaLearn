package com.zjgyjd.control;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.ItemsEx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@Controller
public class ItemsController {
    @RequestMapping(value = "/abc")
    public void queryItemsList(HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-mapper.xml");

        ItemsCustomMapper itemsCustomMapper = (ItemsCustomMapper) applicationContext.
                getBean("itemsCustomMapper");
        ItemsEx itemsEx = new ItemsEx();
       // itemsEx.setName("本");
        List<ItemsEx> itemsExList = itemsCustomMapper.queryItemsByName(itemsEx);
        System.out.println(itemsExList);
        request.setAttribute("itemslistKey",itemsExList);
        request.getRequestDispatcher("/showitems.jsp").forward(request,response);
    }
}
