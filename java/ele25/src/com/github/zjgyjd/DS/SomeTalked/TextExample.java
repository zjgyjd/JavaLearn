package com.github.zjgyjd.DS.SomeTalked;

@Tester(
    author ="a=zjgyjd",
    date = "2019-04-20"
)
public class TextExample {
    //注解Annotation 配置代码化
    @Test
    public void testA(){
        throw new RuntimeException();
    }

    @Test(enabled = true)
    public void testB(){
        if(false){
            throw new RuntimeException();
        }
    }

    @Test(enabled = false)
    public void testC(){
            throw new RuntimeException();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String className = "com.github.zjgyjd.DS.SomeTalked.TextExample";
        Class testClass = Class.forName(className);
    }
}
