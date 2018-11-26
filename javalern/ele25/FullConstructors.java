package com.github.zjgyjd;

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing MyExceotion from g()");
        throw new MyException("Origination in g()");
    }

    public static void main(String[] args) {
        try{
            f();
        }catch(MyException e){
            e.printStackTrace(System.out);
        }
        try{
            g();
        }catch(MyException e){
            e.printStackTrace(System.out);
        }
    }
}
