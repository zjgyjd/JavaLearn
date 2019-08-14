package com.zjgyjd;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TestXml {
    public static void main(String[] args) throws DocumentException {
        Map<String , String> nameToClassName =  new HashMap<>();
        Map<String , String> nameToMapping = new HashMap<>();
        SAXReader reader = new SAXReader();
        Document doc = reader.read(TestXml.class.getClassLoader().getResource("web.xml"));
        Element root = doc.getRootElement();
        for(Iterator<Element> it = root.elementIterator(); it.hasNext();){
            Element element = it.next();
            switch (element.getName()){
                case "controller" :{
                    String name = element.element("name").getText();
                    String className = element.element("class").getText();
                    nameToClassName.put(name , className);
                    break;
                }
                case "mapping" :{
                    String name = element.element("name").getText();
                    String url = element.element("url-pattern").getText();
                    nameToMapping.put(name , url);
                    break;
                }
            }
        }

        System.out.println(nameToClassName);
        System.out.println(nameToMapping);
    }

}
