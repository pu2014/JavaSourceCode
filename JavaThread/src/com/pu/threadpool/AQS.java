package com.pu.threadpool;

/**
 * Description: AbstractQueuedSychronized  locks包下
 * 基于AQS的有 ReetrantLock，semaphore FutureTask
 * Created By @Author my on @Date 2020/4/7 17:56
 */
public class AQS {
    /**
     * 如果被访问的资源是空闲的，那么当前请求该资源的线程设置为有效线程
     * 并且将共享资源设置为锁定状态。如果被占用，CLH队列锁实现，将暂时获取不到
     * 锁的线程加入到队列中
     */

    //表示同步状态
    private volatile int state; //共享变量，使用volatile修饰保证线程可见

    //队列完成获取资源线程的排队工作
    //CAS对同步状态进行修改


    /**
     * 两种资源共享方式
     *   & Exclusive：独占，只有一个线程能执行，如ReentrantLock
     *          * fair
     *          * unfair
     *   & share ： Semaphore等
     */
}
