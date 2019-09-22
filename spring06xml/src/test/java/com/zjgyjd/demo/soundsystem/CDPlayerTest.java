package com.zjgyjd.demo.soundsystem;

import com.zjgyjd.demo.soudsystem.CDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration("classpath:applicationContext.xml")
public class CDPlayerTest {
    @Autowired
    private CDPlayer cdPlayer1;

    @Autowired
    private CDPlayer cdPlayer2;


    @Autowired
    private CDPlayer cdPlayer3;

    @Test
    public void Test01(){
        cdPlayer1.play();
    }

    @Test
    public void Test02(){
        cdPlayer2.play();
    }

    @Test
    public void Test03(){
        cdPlayer2.play();
    }
}
