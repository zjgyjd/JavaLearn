package com.zjgyjd;

import java.io.*;

public class DIYClassLoder extends ClassLoader {
    private static final String HOME = System.getenv("JM_HOME");

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("加载类的name :"+name);
        if(name == null){
            return null;
        }
        //加载类
        File classFile = getClassFile(name);
        // 2. 读取该文件的内容
        byte[] buf = new byte[0];
        try {
            buf = readClassBytes(classFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. 调用 defineClass，转为 Class
        return defineClass(name, buf, 0, buf.length);
    }

    private File getClassFile(String name) {
        String filename = HOME + File.separator + "webapp" + File.separator + "WEB-INF" + File.separator + "classes" + File.separator + name + ".class";
        return new File(filename);
    }

    private byte[] readClassBytes(File classFile) throws IOException {
        int len = (int) classFile.length();
        byte[] buf = new byte[len];
        InputStream is = new FileInputStream(classFile);
        is.read(buf, 0, len);
        return buf;
    }
}
