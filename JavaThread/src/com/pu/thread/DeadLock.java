package com.pu.thread;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/7 18:15
 */
public class DeadLock {
    //互斥条件  任意时刻只能由一个线程占用
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    /**
     * 死锁参数条件：
     * 1.互斥条件
     * 2.请求与保持
     * 3.不剥夺条件只能自己释放
     * 4. 循环等待，嵌套
     * @param args
     */
    public static void main(String[] args) {

        new Thread(()->{
            //请求与保持
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + " get lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " wait lock2");
                //不剥夺条件只能自己释放
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + " get lock2");
                }
            }
        }, "线程1").start();

        new Thread(()->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + " get lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " wait lock1");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + " get lock1");
                }
            }
        },"线程2").start();
    }
}
