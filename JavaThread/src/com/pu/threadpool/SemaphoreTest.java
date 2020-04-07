package com.pu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description:信号量 - 允许多个线程同时访问
 * sychronized 和 ReentrantLock 都是依次只允许一个线程访问某一个资源  线程复用
 * Semaphore 可以指定多个线程同时访问某个资源 线程还是那么多，只是挂起或者阻塞了  基于互斥锁 线程同步
 * ThreadPool 也可以限流，但是是线程异步
 * Created By @Author my on @Date 2020/4/7 17:10
 */
public class SemaphoreTest {
    //请求数量
    private static final int MAX_COUNT_REQUEST = 50;

    public static void main(String[] args) {
        //创建固定的线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        //一次允许执行的线程数量
        final Semaphore semaphore = new Semaphore(5);

        for(int i = 0; i < MAX_COUNT_REQUEST; i++){
            final int count = 1;
            threadPool.execute(()->{
                try {
                    semaphore.acquire();//获取一个许可，所以当前可以允许数量为20/1=20
                    System.out.println(semaphore.availablePermits());
                    test(count);
                    semaphore.release(); //释放一个许可
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    private static void test(int count) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "  count : " + count);
        Thread.sleep(1000);
    }
}
