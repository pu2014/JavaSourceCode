package com.pu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description：
 * 在我们平时的项目开发过程中，基本上很少会直接使用到反射机制，但这不能说明反射机制没有用，实际上有很多设计、开发
 * 都与反射机制有关，例如模块化的开发，通过反射去调用对应的字节码；动态代理设计模式也采用了反射机制，
 * 还有我们日常使用的 Spring／Hibernate 等框架也大量使用到了反射机制。
 *
 * 我们在使用 JDBC 连接数据库时使用 Class.forName()通过反射加载数据库的驱动程序；
 * Spring 框架的 IOC（动态加载管理 Bean）创建对象以及 AOP（动态代理）功能都和反射有联系；
 * 动态配置实例的属性；
 *
 * @author Pubojian
 * @date 2020/3/14 23:57
 */
public class UserRefTest {
    public static void main(String[] args) throws Exception {
        //获取对象
        Class<?> targetClass = Class.forName("com.pu.reflection.User");
        //创建实例
        User user = (User) targetClass.newInstance();
        //获取方法
        //获取公共
        Constructor con = targetClass.getConstructor(String.class);
        User user1 = (User) con.newInstance("xmy");
        Method[] methods = targetClass.getMethods();
        for(Method me : methods){
            System.out.println(me);
        }

        Method[] methods1 = targetClass.getDeclaredMethods();
        for(Method m : methods1){
            System.out.println(m.getName());
        }
        //获取指定方法
        Method publicMethod = targetClass.getMethod("publicMethod", String.class);
        //调用
        publicMethod.invoke(user, "java");
        publicMethod.invoke(user1, "java");
        //获取私有字段
        Field field = targetClass.getDeclaredField("name");
        //取消安全检查
        field.setAccessible(true);
        field.set(user, "xmy");
        //获取私有方法
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(user);


    }
}
