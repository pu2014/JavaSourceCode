package com.pu.thread;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


/**
 * Description:ReentrantLock独占锁，更适合复杂的并发场景
 * ReetrantLock 和 Sychronized 的对比
 * 1. 都是独占锁
 *      *Sychronized加锁和解锁的过程自动进行，易操作不灵活
 *      *ReetrantLock 加锁和解锁需要手动进行，不易操作，非常灵活
 * 2. 都可重入锁
 *      *Sychronized，不用担心最后释放锁
 *      *ReetrantLock，需要手动释放锁
 * 3. sychronized 不可以响应中断，一个线程获取不到锁就一直等着
 *    ReetrantLock 可以响应中断
 * 4. ReentrantLock 可以实现公平锁机制，也就是在锁上等待时间最长的线程获取锁的使用权
 * 5. ReentrantLock 可以选择性通知
 *
 * Created By @Author my on @Date 2020/4/7 11:39
 */
public class ReentrantLock {

    private static final Lock lock = new java.util.concurrent.locks.ReentrantLock();
    static Lock lock1 = new java.util.concurrent.locks.ReentrantLock();
    static Lock lock2 = new java.util.concurrent.locks.ReentrantLock();

    public static void main(String[] args) {
        /**
         * 与sychronized对比
        new Thread(()-> method1(), "thread 1").start();
        new Thread(()-> method1(), "thread 2").start();

        new Thread(()-> method2(), "thread 3").start();
        new Thread(()-> method2(), "thread 4").start();
         */

        /*new Thread(()-> method3(), "thread A").start();
        new Thread(()-> method3(), "thread B").start();
        new Thread(()-> method3(), "thread C").start();
        new Thread(()-> method3(), "thread D").start();
        new Thread(()-> method3(), "thread E").start();
        new Thread(()-> method3(), "thread F").start();*/

        Thread threadA = new Thread(new ThreadDemo2(lock1, lock2));
        Thread threadB = new Thread(new ThreadDemo2(lock2, lock1));
        threadA.start();
        threadB.start();
        threadA.interrupt(); // 线程中断
    }

    public static void method1() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 公平锁实现
     * new  RentrantLock(true) 默认不公平
     */
    public static final Lock fairLock = new java.util.concurrent.locks.ReentrantLock(true);
    public static void method3() {
        for(int i = 0; i < 2; i++){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                fairLock.unlock();
            }
        }
    }

    /**
     * 响应中断
     * 死锁案例
     */
    static class ThreadDemo implements Runnable{
        Lock lockA;
        Lock lockB;

        public ThreadDemo(Lock lockA, Lock lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            try{
                lockA.lockInterruptibly();
                TimeUnit.MILLISECONDS.sleep(50);
                lockB.lockInterruptibly();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lockA.unlock();
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源");
            }
        }
    }

    /**
     * 解决死锁问题
     */
    static class ThreadDemo2 implements Runnable{
        Lock lockA;
        Lock lockB;

        public ThreadDemo2(Lock lockA, Lock lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            try{
                if(!lockA.tryLock()) TimeUnit.MILLISECONDS.sleep(50);
                if(!lockB.tryLock()) TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lockA.unlock();
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + "获取到了资源");
            }
        }
    }


}
