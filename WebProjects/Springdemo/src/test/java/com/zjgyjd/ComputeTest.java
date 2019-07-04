package com.zjgyjd;

import com.zjgyjd.Compute.XmlShapeComputer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComputeTest {
    @Test
    public void ComputeTest(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        XmlShapeComputer xmlShapeCompute = (XmlShapeComputer)
                context.getBean("shapeCompute");
        System.out.println(xmlShapeCompute.compute("circular"));
    }
}
