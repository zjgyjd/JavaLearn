package com.zjgyjd.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChanceServlet extends HttpServlet {
    private int chanceNumber;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        chanceNumber = Integer.parseInt(config.getInitParameter("chanceNumber"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset=\"UTF-8\"")
                .append("</head>")
                .append("<body>");
        String name = request.getParameter("name");
            if(chanceNumber > 0){
            chanceNumber = chanceNumber -1;
            writer.append("<h1>")
                    .append(name)
                    .append("剩余")
                    .append(String.valueOf(chanceNumber))
                    .append("次机会")
                    .append("</h1>");
        }else {
            writer.append("<h1>")
                    .append(name)
                    .append("没有机会了")
                    .append("</h1>");
        }
        writer.append("</body>").append("</html>");
    }

    @Override
    public void destroy(){
        super.destroy();
        System.out.println("destroy");
    }
}
