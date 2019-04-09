package com.github.zjgyjd.generic;
/*
1.泛型类
1.1 className<T,S> 使用时指定具体类型
1.2 ? extends classType 指定泛型上限

2.泛型方法
2.1 <T> returnValue method(T args)
2.2 类和方法相互独立
2.3 ?,? extends classType(不能改内容),? super classType(可改)

3.泛型接口
3.1 interfaceName<T>
3.2 className<T> implements interfaceName<T>
3.3 className    implements interfaceName<String>
3.3  结合内部类

 4.泛型擦除
 4.1 泛型只在编译阶段,运行擦除
 4.2 T 未知上限时,统一用Object
 4.3 指定上限时类型统一设置为上限类型
 */