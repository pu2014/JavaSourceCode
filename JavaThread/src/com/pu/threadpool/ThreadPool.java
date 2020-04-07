package com.pu.threadpool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:线程池
 * 1. 降低资源消耗。通过重复利用已经创建的线程池降低线程创建和销毁造成的损耗
 * 2. 提高响应速度
 * 3. 提高线程的可管理性
 * Created By @Author my on @Date 2020/4/7 16:15
 */
public class ThreadPool {
    //alibab手册 强制不允许使用Executor去创建，而是通过ThreadPoolExecutor的方式
    /**
     * ThreadPoolExecutor 参数分析(Executors.newFixedThreadPool()基于此类)
     *
     * 3个重要的
     * corePoolSize：核心线程数定义最小可以同时运行的线程数量
     * maximumPoolSize：当队列中存放的任务达到队列容量时，当前可以同时运行的线程数量的最大线程数
     * workQueue：当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到，新任务就会被存放在队列
     *
     * 其他
     * keepAliveTime:当前线程池中的线程数量大于corepoolSize的时候，如果没有新的任务提交，不会立即销毁，会等待时间超过keepAliveTime才会销毁
     * unit：参数的时间单位
     * handler：饱和策略
     *      * AbortPolicy:拒绝新任务
     *          Spring默认
     *      * CallerRunsPolicy:调用自己的线程运行任务 影响性能
     *      * DiscardPoilcy:直接丢弃任务
     *      * DiscardOldestPolicy: 丢弃最早未处理的任务
     *  execute
     *      |
     *  核心线程池是否满了--y--等待队列是否满了--y--线程池是否最大--y--按照策略处理
     *      |                       |               |
     *   创建线程                 加入队列          创建线程
     */

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 5;
    private static final long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i = 0; i < 15; i++) {

            //提交一个任务到线程池
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  start time = " + new Date());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  end time = " + new Date());
                }
            });
        }
        executor.shutdown();
    }

}
