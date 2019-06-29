package com.zjgyjd.control;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import com.zjgyjd.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ItemsController_01 {


    @RequestMapping(value = "/c")
    public void queryItemsList(HttpServletRequest request,
                               HttpServletResponse response) throws Exception{
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext-mapper.xml");
        ItemsCustomMapper itemsCustomMapper = (ItemsCustomMapper) applicationContext.getBean("itemsCustomMapper");
        List<ItemsCustom> itemsExList = itemsCustomMapper.queryItemsByName(null);
        request.setAttribute("itemslistKey",itemsExList);
        request.getRequestDispatcher("/showitems.jsp").forward(request,response);
    }
}
