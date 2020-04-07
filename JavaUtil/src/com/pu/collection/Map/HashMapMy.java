package com.pu.collection.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 12:34
 */
public class HashMapMy {
    Map map = new HashMap();

    /**
     * 1. 底层实现是数组加链表
     * 2. 扩容 负载因子 0.75f
     *      * 每次扩容是创建一个新的Node数组，长度为原来的两倍
     *      * 遍历原来的Entry数组，把所有的 Entry 重新 hash 到数组
     * 3. 链表插入是尾插法，防止转移后链表顺序倒置，出现死循环
     * 4. 不安全，put/get都没有同步锁
     * 5. 初始长度是16，是为了便于取hash值 且16 - 1 = 1111， & 运算直接跨域取最末尾几位
     * 6. 必须重写hashcode 和 equails
     * 7. 注意区分容量和大小，返回的是size
     * 8. 链表在超过8个为红黑树，小于6的时候为链表(泊松分布）
     *
     */

    // 哈希的公式
    // index = HashCode(key) & (Length - 1)
    //put(K, V)
    //首先计算k来算出k的哈希值计算出插入的位置，如果该位置没有元素就插入，有元素就在该点的尾部插入
    //节点
    static class Node<K, V> implements Map.Entry<K, V> {
        final int  hash;
        final  K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key) {
            this.hash = hash;
            this.key = key;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
    //初始大小为16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    //超过就扩容
    static final float DEFAULT_LOAD_FACTOR = 0.75f;


}
