package com.zjgyjd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryServlet extends HttpServlet {
    private Map<String, String> cityMap = new HashMap<String, String>();
    private Map<String, List<String>> scenicSpot = new HashMap<String, List<String>>();
    @Override
    public void init() throws ServletException {
        super.init();
        List<String> xian = new ArrayList<String>();
        xian.add("华清池");
        xian.add("兵马俑");
        xian.add("大雁塔");
        scenicSpot.put("xian", xian);
        cityMap.put("xian", "西安");

        List<String> baoJi = new ArrayList<String>();
        baoJi.add("太白山");
        baoJi.add("法门寺");
        baoJi.add("关山牧场");
        scenicSpot.put("baoJi", baoJi);
        cityMap.put("baoJi", "宝鸡");

        List<String> xianyang = new ArrayList<String>();
        xianyang.add("乾陵");
        xianyang.add("袁家村");
        scenicSpot.put("xianyang", xianyang);
        cityMap.put("xianyang", "咸阳");
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        this.doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String city = request.getParameter("city");
        List<ScenicsDto> scenicsDtoArrayList = new ArrayList<ScenicsDto>();
        if(city == null||city.length() == 0){
            for(Map.Entry<String,List<String>> entry: scenicSpot.entrySet()){
                String cityKey = entry.getKey();
                List<String> scenics = entry.getValue();
                for(String item: scenics){
                    ScenicsDto scenicsDto = new ScenicsDto();
                    scenicsDto.setCity(cityMap.get(cityKey));
                    scenicsDto.setName(item);
                    scenicsDtoArrayList.add(scenicsDto);
                }
            }
        }else{
            List<String> scenics = scenicSpot.get(city);
            if(scenics == null){
                scenics = new ArrayList<String>();
            }
            for (int i = 0; i < scenics.size(); i++) {
                ScenicsDto scenicsDto = new ScenicsDto();
                scenicsDto.setCity(cityMap.get(city));
                scenicsDto.setName(scenics.get(i));
                scenicsDtoArrayList.add(scenicsDto);
            }
        }
        response.setContentType("text/html; charset = UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append(
                "<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>景点</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table border=\"1\">\n" +
                " <thead>\n" +                 //表头
                " <tr>\n" +
                " <td>编号</td>\n" +
                " <td>所在城市</td>\n" +
                " <td>景点名称</td>\n" +
                " </tr>\n" +
                " </thead>\n" +
                " <tbody>");
        int id = 1;
        for (ScenicsDto dto: scenicsDtoArrayList){
            writer.append("<tr>")
                    .append("<td>").append(String.valueOf(id)).append("</td>")
                    .append("<td>").append(dto.city).append("</td>")
                    .append("<td>").append(dto.name).append("</td>")
                    .append("</tr>");
            id = id + 1;
        }
        writer.append("</tbody>\n"+
                "</table>\n"+
                "</body>\n"+
                "</html>");
    }

    private static class ScenicsDto {
        private String city;
        private String name;

        public void setCity(String s) {
            city = s;
        }

        public void setName(String item) {
            name = item;
        }
    }
}
