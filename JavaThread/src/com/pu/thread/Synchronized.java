package com.pu.thread;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/7 10:12
 */
public class Synchronized {
    /**
     * synchronized 关键字解决的是多个线程之间访问资源的同步性，synchronized关键字可以保证
     *      被他修饰的方法或者代码块在任意时刻只能有一个线程执行
     *
     * 早期： synchronized 属于重量级锁，效率低下，监视器锁（monitor）是依赖于底层的操作系统的
     *      Mutex Lock 来实现的。基于操作系统的线程（需要从用户态切换到内核态） 效率低
     * 1.6后：锁的膨胀优化
     *      & 修饰实例方法：作用于实例方法：进入同步代码块需要获得当前对象实例的锁
     *      & 修饰静态方法：给当前类加锁，会作用于类的所有对象实例，（static 表明这是该类的一个静态方法，
     *          不管new了多少个对象，只有一份）
     *          线程a --> 访问静态synchronized方法占用的锁是当前类的锁
     *          线程b --> 访问非静态synchronized方法占用的锁是当前实例对象锁
     *      & 修饰代码块：指定加锁对象，对给定对象加锁，进入同步代码库前要给定对象的锁
     *
     * 1.6后的底层优化：
     *      & 偏向锁：在无竞争的情况下会把整个同步都消除掉
     *      & 轻量级锁： 在没有多线程竞争的前提下，减少传统的重量级锁使用操作系统的Mutex lock
     *          产生的性能消耗，因为使用轻量级锁不需要申请互斥量：轻量级锁的加锁和解锁都用到了
     *          CAS操作
     *      & 自旋锁和自适应自旋：线程没有挂起/恢复的开销：自适应锁（自适应自旋时间）
     *      & 锁消除和锁粗化
     *
     *
     */


    /**
     * Description:修饰代码块
     * 反编译 javap -c -s -v -l Sychronized.class
     * 实现是基于monitorenter 和 monitorexit 指令
     * 获取锁就是获取monitor（monior对象存在于每个java对象的对象头中）
     *      * 这也是为什么每一个对象都可以作为锁的原因
     *      * enter后锁计数器加1 exit后锁计数器为0表示锁被释放
     *      * 获取锁失败就需要阻塞等待
     * @auther
     */
    public void method(){
        synchronized (this){
            System.out.println("sychronized 代码块");
        }
    }

    /**
     * Description:修饰方法
     * 没有使用monitor指令，而是使用ACC_SYNCHRONIZED标志，指明该方法是否是一个同步方法
     * @auther
     */
    public synchronized void method2(){
        System.out.println("sychronized 方法");
    }

}
