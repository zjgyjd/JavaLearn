package com.zjgyjd.demo.soundsystem;

import com.zjgyjd.demo.soudsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest {
    @Autowired
    private CompactDisc compactDisc1;
//    @Autowired
//    private CompactDisc compactDisc2;
//    @Autowired
//    @Qualifier("compactDisc2")
//    private CompactDisc compactDisc3;
    @Test
    public void test01(){
        compactDisc1.play();
//        compactDisc2.play();
//        compactDisc3.play();
    }
    @Autowired
    @Qualifier("aLong")
    Long n ;
    @Test
    public void testRusult(){
        long wait = 5;
        long second = 0;
        System.out.println(n);
        for (int i = 1; i <= n; i++) {
            if(second == wait){
                second = 0;
                wait = wait * 2;
            }
            second++;
        }
        System.out.println(second);
    }
}
