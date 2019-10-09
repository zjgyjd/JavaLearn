Spring MVC
运用MVC将数据库内容显示到页面上
1.加jar包
Spring core
Spring beans
Spring context
Spring web
Spring MVC
jstl和el
Servlet和jsp
mysql

2.创建items类,与数据库对应;创建controller包,创建controller类\

3.创建applicationContext-control
    1.创建beans,为controller类,即创建处理器
    2.创建适配器org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter
    3.创建映射器org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping
    4.在原类上implement一个Controller类web.servlet的,完成复写类
4.回到web配置前端控制器
<servlet>
XXXXXX

5.配置视图解析器
    1.创建beans,org.springframework.web.servlet.view.InternalResourceView
        1.配置前缀和后缀就可以只写名字

6.写前端页面

7.还有其他的适配器,要继承不同的接口.适配器映射器可以混用
8.另外有注解方式
1.配置扫描包
2.写注解
