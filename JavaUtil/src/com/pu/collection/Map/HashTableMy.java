package com.pu.collection.Map;

import java.util.Hashtable;
import java.util.Map;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 16:51
 */
public class HashTableMy {


    /**
     * 1. 线程安全 初始容量11  扩容 翻倍 + 1
     * 2. 对数据操作都会上锁，效率低下
     * 3. 安全失败机制（fail-safe）不可以存储null值（hashmap可以）
     *      * 无法判断对应的key是不存在还是为空
     * public synchronized V get(Object key) {
     *         Entry<?,?> tab[] = table;
     *         int hash = key.hashCode();
     *         int index = (hash & 0x7FFFFFFF) % tab.length;
     *         for (Entry<?,?> e = tab[index] ; e != null ; e = e.next) {
     *             if ((e.hash == hash) && e.key.equals(key)) {
     *                 return (V)e.value;
     *             }
     *         }
     *         return null;
     *     }
     * 4. hashMap时fail-fast  hashTable 不是
     *      *fail—fast 在迭代器遍历一个集合对象时，如果遍历过程中对集合对象的内容做了修改就会出现异常
     * 5. 全表锁
     *
     */
    Map map = new Hashtable(0);
}
