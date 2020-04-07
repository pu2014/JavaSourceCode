package com.pu.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.SimpleFormatter;

/**
 * Description:变量是可以被任何一个线程访问并修改的，实现每个线程有自己专属的本地变量
 *
 * 底层使用ThreadLocalMap实现键值对 会造成内存泄露 需要手动remove
 *
 * Created By @Author my on @Date 2020/4/7 12:50
 */
public class ThreadLocalTest implements Runnable {
    // 创
    ThreadLocal threadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        for(int i = 0; i < 10; i++){
            Thread t = new Thread(threadLocalTest, "" + i);
            Thread.sleep(1000);
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "default format" + threadLocal.get().toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadLocal.set(new SimpleDateFormat());
        System.out.println(Thread.currentThread().getName() + "new format" + threadLocal.get().toString());


    }
}
