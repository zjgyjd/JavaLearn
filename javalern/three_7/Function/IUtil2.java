package com.github.zjgyjd.Function;

@FunctionalInterface
public interface IUtil2 {
    Integer compare(Integer arg1, Integer arg2);

    public static void main(String[] args) {
        IUtil2 iUtil2 = new IUtil2() {

            @Override
            public Integer compare(Integer arg1, Integer arg2) {
                return arg1 - arg2;
            }
        };
        IUtil2 iUtil21 = (arg1, arg2) -> {
            return arg1 - arg2;
        };
        IUtil2 iUtil22 = Integer::compareTo;//类::普通方法引用
    }
}
