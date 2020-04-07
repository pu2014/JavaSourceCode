package com.pu.collection.Set;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 11:50
 */

/**
 * 1 底层基于HashMap实现
 * 2 利用成员对象来计算hashcode的值，对于两个对象来说hashcode可能相同，
 *   需要使用equals（）方法来判断对象的相等性
 * 3 检查重复：先计算hashcode值判断加入位置，
 *      如果没有相符的hashcode，就没有重复对象
 *      如果用相同的hashcode就调用equals方法判断
 * 4 线程不安全
 * 5 插入的顺序依据hashcode ，和遍历顺序不一样
 */
public class HashSetMy {
    HashSet hashSet = new HashSet();
    //extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable

    //底层使用HashMap实现
    //private transient HashMap<E,Object> map;

    //add方法
    /**
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
     */
}
