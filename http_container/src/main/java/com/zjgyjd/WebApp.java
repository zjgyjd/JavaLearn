package com.zjgyjd;

import com.zjgyjd.controller.Controller;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WebApp {
    public static final String HOME = System.getenv("JM_HOME");
    public Map<String, String> nameToClassName = new HashMap<>();
    public Map<String, String> nameToMapping = new HashMap<>();

    public static WebApp webApp()  {
        WebApp webApp = new WebApp();
        SAXReader reader = new SAXReader();
        URL xUrl = null;
        try {
            xUrl = new File(HOME + File.separator + "webapp"
                    + File.separator + "WEB-INF" + File.separator +File.separator + "web.xml").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = reader.read(xUrl);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ) {
            Element element = it.next();
            switch (element.getName()) {
                case "controller": {
                    String name = element.element("name").getText();
                    String className = element.element("class").getText();
                    webApp.nameToClassName.put(name, className);
                    break;
                }
                case "mapping": {
                    String name = element.element("name").getText();
                    String url = element.element("url-pattern").getText();
                    webApp.nameToMapping.put(name, url);
                    break;
                }
            }
        }

        return webApp;
    }

    public Controller findController(Request request) {
        //根据Request的url找到name
        String name = this.nameToMapping.get(request.getUrl());
        System.out.println("Request找到的 "+ name);
        //根据name找到class
        String className = this.nameToClassName.get(name);
        System.out.println("class找到的 "+ name);
        try {
            return (Controller) new DIYClassLoder().findClass(className).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
