package com.pu.collection.Set;

import java.util.Set;
import java.util.TreeSet;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 12:10
 */
public class TreeSetMy {

    /**
     * 底层是TreeMap实现  红黑树  实现唯一 有序
     * 可以实现自然排序 比较器排序
     */
    Set<Integer> set = new TreeSet<>((o1,o2)->(o1.compareTo(02)));
    //private transient NavigableMap<E,Object> m
}
