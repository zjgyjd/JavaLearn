package com.github.zjgyjd.feature;
//支持静态导入即import static .....
public class TestFeature {
    /*
    java语言桌面版程序
    java.awt
    javax.swing 目前不流行

    客户端程序
    java FX (JavaSE + FX API + XML + CSS + HTML4/5 + JavaScript)
    Android(JavaSE + Google Android API => Linux Android
     */

    public static int add(int[] data){
        //原来方法
        if(data == null){
            return 0;
        }
        int sum =0;
        for (int i = 0; i < data.length; i++) {
            sum+=data[i];
        }
        return sum;
    }

    public static int add1(int... data){//...代表可变参数,自己创建数组
        if(data == null){
            return 0;
        }
        int sum =0;
        for (int i = 0; i < data.length; i++) {
            sum+=data[i];
        }
        return sum;
        /*
        测试用例:
          //可变参数 ...
        System.out.println(add1());
        System.out.println(add1(1));
        System.out.println(add1(1,2,3,4,5));
        //此时可以传多个参数,不用手动写为数组
         */
    }
    public void print(String message,String... args){//可变参数必须在参数列表的最后一个
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        for (int i = 0; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }
        System.out.println(stringBuilder.toString());//此时可以不用加号,直接用逗号
    }



    public static void main(String[] args) {

    }
}
