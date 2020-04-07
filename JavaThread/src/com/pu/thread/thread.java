package com.pu.thread;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/7 18:08
 */
public class thread {

    /**
     * 并发编程的问题：
     *      & 内存泄漏，上下文切换，死锁等
     *
     * 状态：
     *      & new  初始状态 没有start
     *      & runnable  允许状态
     *      & blocked 阻塞状态，表示线程阻塞于锁
     *      & waiting 等待状态 wait()
     *      & time_waiting 超时等待，可以自行返回 sleep(xx)
     *      & terminated 终止状态 run() 结束后
     *
     * 方法：
     *      sleep() 没有释放锁
     *      wait() 释放了锁  -- 需要执行 notify()或者notifyAll()唤醒
     *              或者设置 wait(long timeout)
     *              sleep可以自动唤醒
     *
     * 问题：执行start方法时会执行run，不直接调用run
     *      new 一个 thread，线程进入new状态，调用start方法，会启动一个线程并使线程进入了就绪状态。
     *          start会执行相应的准备工作，然后自动执行run()方法。
     *      直接执行run，只是main线程的普通方法去执行
     */


}
