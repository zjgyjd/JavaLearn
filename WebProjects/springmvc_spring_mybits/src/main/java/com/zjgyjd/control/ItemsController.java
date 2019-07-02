package com.zjgyjd.control;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import com.zjgyjd.service.ItemsService;
import com.zjgyjd.service.ItemsServiceImp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/abc")
    public void queryItemsList(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        List<ItemsCustom> itemsExList = itemsService.queryItemsByName(null);
        request.setAttribute("itemslistKey", itemsExList);
        request.getRequestDispatcher("/showitems.jsp").forward(request, response);
    }

    @RequestMapping(value = "/d")
    public String deleteSingle(@Param("id") Integer id) throws Exception {
        itemsService.deleteByPrimaryKey(id);
        return "forward:abc";
    }
}
