package com.zjgyjd.control;

import com.zjgyjd.mapper.ItemsCustomMapper;
import com.zjgyjd.po.ItemsCustom;
import com.zjgyjd.po.ItemsEx;
import com.zjgyjd.service.ItemsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class ItemsUpdateController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/u")
    public void queryItemsList(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        ItemsCustom eq = itemsService.selectByPrimaryKey(id);
        request.setAttribute("items", eq);
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }
    @RequestMapping(value = "/t")
    public ModelAndView updateItems(HttpServletRequest request,HttpServletResponse response,ItemsEx itemsEx) throws Exception {
        String time = request.getParameter("createTime");
        if(time != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            itemsEx.setCreatetime(df.parse(time));
        }
        itemsService.insert(itemsEx);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/abc");
        return modelAndView;
    }
}
