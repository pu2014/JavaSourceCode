package com.pu.collection.Set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 12:04
 */
public class LinkedHashSetMy {
    /**
     * 1 继承HashSet 内部使用LinkedhashMap
     * 2 插入顺序 == 遍历顺序
     */
    //extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable
    Set set = new LinkedHashSet();

}
