package com.pu.singleton;


/**
 * Description:双重校验实现对象单列（线程安全）
 * Created By @Author my on @Date 2020/4/7 10:28
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;
    //volatile 禁止jvm指令重排序

    private Singleton(){}

    private static Singleton getUniqueInstance(){
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    /**
                     * 1. 为uniqueInstance分配内存空间
                     * 2. 初始化uniqueInstance
                     * 3. 将uniqueInstance指向分配的内存地址
                     */
                    uniqueInstance = new Singleton();

                }
            }
        }
        return uniqueInstance;
    }
}
