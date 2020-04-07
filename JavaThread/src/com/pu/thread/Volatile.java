package com.pu.thread;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/7 12:26
 */
public class Volatile {
    /**
     * volatile -- > JMM 模型
     * 线程主体 --> 工作内存 --> 主内存
     * read  load use
     * write store assign
     * 原理： 汇编LOCK前缀指令可以锁住该内存的缓存并回写到主内存
     * 最开始总线加锁，串行，效率低
     * 然后采用总线嗅探，缓存一致性协议
     * 缓存锁定-->t1值改变-->总线嗅探机制-->发现值改变-->t2工作内存失效-->重新加载
     *
     *
     * 可见性：缓存一致
     * 有序性：禁止JVM的指令重排序
     * 原子性：单一操作具有，i++这种不具有，会失效
     * volatile ： 轻量级实现 只能用于变量 不阻塞 保证可见性
     * sychronzied ：方法 和 代码块 可能阻塞 保证同步性
     */
    private static volatile int count = 0;

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(()->{
                for(int j = 0; j < 1000; j++){
                    count++;
                }
            }).start();
        }
        System.out.println(count);
    }
}
