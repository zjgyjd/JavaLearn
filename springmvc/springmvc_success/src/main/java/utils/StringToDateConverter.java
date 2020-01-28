package utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        //判断
        if (s == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        //将字符串转换成日期
        try {
            return df.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
