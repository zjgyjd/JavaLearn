package com.github.zjgyjd.id.impl;

import com.github.zjgyjd.id.IdGenerator;

import java.util.UUID;

/**
 * 简化的UUID，去掉了横线
 * <p>
 * Author: secondriver
 * Created: 2018/10/17
 */
public class Uuid implements IdGenerator {
    
    @Override
    public String id() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
