package com.github.zjgyjd.getclass;

import java.io.File;

/**
 * 自定义类加载器,有问题
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
    private byte[] loadClassByte(String name){
        File file = new File(name);
        return null;
    }
}
