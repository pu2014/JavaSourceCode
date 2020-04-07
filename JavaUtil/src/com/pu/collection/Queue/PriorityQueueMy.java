package com.pu.collection.Queue;

import java.util.PriorityQueue;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 12:41
 */
public class PriorityQueueMy {


    /**
     * 二叉小顶堆实现，可以用一棵完全二叉树表示（任意一个非叶子节点的权值，都不大于其左右子节点的权值）
     * 1>PriorityQueue是一种无界的，线程不安全的队列
     * 2>PriorityQueue是一种通过数组实现的，并拥有优先级的队列
     * 3>PriorityQueue存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器
     *
     */

    PriorityQueue priorityQueue = new PriorityQueue();

    //底层数组实现
    //transient Object[] queue

    //默认大小为11

    //private static final int DEFAULT_INITIAL_CAPACITY = 11;
}
