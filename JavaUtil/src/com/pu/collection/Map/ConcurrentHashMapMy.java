package com.pu.collection.Map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 17:02
 */
public class ConcurrentHashMapMy {
    ConcurrentHashMap map = new ConcurrentHashMap();
    // 默认大小和Hashmap一致
    /**
     * 1. CAS + synchronized 保证并发安全性
     * 2. Node 且 value 和 next 都用了 Volatile 修饰，保证了可见性
     *      * 可见性： 保证不同线程对这个变量进行操作的可见性，即一个线程修改某个变量的值，这新值对其他线程来说是立即可见的
     *      * 有序性： 禁止指令重排序
     *      * 只保证对单次读写的原子性，i++这种不能保证原子性
     * 3. 存：
     *      1：计算hashcode
     *      2：是否需要初始化
     *      3：定位当前位置的Node，如果为空表示可以写入数据，利用 CAS 尝试写入，失败则自旋保证成功
     *      4：看是否需要扩容
     *      5：不扩容利用 synchronized 锁写入数据
     *      6：看是否转换为红黑树
     *          * CAS Conmpare And Swap 是乐观锁的实现方式，是一种轻量级锁
     *              * 线程在读取数据时不进行加锁，在准备回写数据时比较原值是否修改,没修改继续写入，修改了就重新执行流程
     *              * 乐观策略认为并发总不会发生
     *              // update a set value = newValue where value = #{oldValue}
     *              * 无法保证ABA问题 --需要加上版本号或者时间戳
     *          * synchronized 以前时重量级锁，被优化后采用(锁升级的方式）
     *              * 偏向锁的优先同一线程然后再次获取锁
     *              * 失败就升级为 CAS 轻量级锁
     *              * 失败就会短暂自旋，防止被系统挂起
     *              * 都失败升级为重量级锁
     */

}
