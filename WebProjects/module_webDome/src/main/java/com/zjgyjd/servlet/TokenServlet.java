package com.zjgyjd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/token")
public class TokenServlet extends HttpServlet {
    private Map<String, List<String>> cityMap = new HashMap<>();
    private Map<String, List<String>> countryMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String pro = req.getParameter("pro");
        String city = req.getParameter("city");
        if (pro == null && city == null) {
            writer.write("没有数据");
        } else {
            if (pro == null) {
                writer.write("pro 参数不能为空");
            } else {
                if (city == null) {
                    List<String> cityList = cityMap.get(pro);
                    StringBuilder sb = new StringBuilder();
                    for (String c : cityList) {
                        sb.append("<a href='/token")
                                .append("?")
                                .append("pro=").append(pro)
                                .append("&")
                                .append("city=").append(c)
                                .append(" '>")
                                .append(pro)
                                .append(",")
                                .append(c)
                                .append("</a>")
                                .append("</br>");
                    }
                    writer.write(sb.toString());
                } else {
                    List<String> cityList = cityMap.get(pro);
                    if (cityList.contains(city)) {
                        StringBuilder sb = new StringBuilder();
                        for (String country : countryMap.get(city)) {
                            sb.append("<a href='/token")
                                    .append("?")
                                    .append("pro=").append(pro)
                                    .append("&")
                                    .append("city=").append(city)
                                    .append(" '>")
                                    .append(pro)
                                    .append(",")
                                    .append(city)
                                    .append(",")
                                    .append(country)
                                    .append("</a>")
                                    .append("</br>");
                        }
                        writer.write(sb.toString());
                    } else {
                        writer.write(city + " 不属于 " + pro);
                    }
                }
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        List<String> shannxi = new ArrayList<>();
        shannxi.add("西安市");
        shannxi.add("宝鸡市");
        shannxi.add("铜川市");
        shannxi.add("咸阳市");
        cityMap.put("陕西省", shannxi);
        List<String> xian = new ArrayList<>();
        xian.add("临潼区");
        xian.add("灞桥区");
        xian.add("长安区");
        countryMap.put("西安市", xian);
    }
}
