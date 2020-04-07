package com.pu.collection.List;

import java.util.*;

/**
 * description：
 * // "static void main" must be defined in a public class.
 *
 * 1. 底层基于数组实现，实现了RandomAccess接口，支持随机访问，优先选择普通for循环，其次foreach（迭代器实现）
 * 2. 扩容机制 先底层数组扩容150% 然后不够就等于需要的大小。
 * 3. 线程不安全 方法没有 synchronized 加锁
 * 3. clone - Arrays.copyOfRange - System.copyOf
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         // 1. initialize
 *         List<Integer> v0 = new ArrayList<>();
 *         List<Integer> v1;                           // v1 == null
 *         // 2. cast an array to a vector
 *         Integer[] a = {0, 1, 2, 3, 4};
 *         v1 = new ArrayList<>(Arrays.asList(a));
 *         // 3. make a copy
 *         List<Integer> v2 = v1;                      // another reference to v1
 *         List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
 *         // 3. get length
 *         System.out.println("The size of v1 is: " + v1.size());;
 *         // 4. access element
 *         System.out.println("The first element in v1 is: " + v1.get(0));
 *         // 5. iterate the vector
 *         System.out.print("[Version 1] The contents of v1 are:");
 *         for (int i = 0; i < v1.size(); ++i) {
 *             System.out.print(" " + v1.get(i));
 *         }
 *         System.out.println();
 *         System.out.print("[Version 2] The contents of v1 are:");
 *         for (int item : v1) {
 *             System.out.print(" " + item);
 *         }
 *         System.out.println();
 *         // 6. modify element
 *         v2.set(0, 5);       // modify v2 will actually modify v1
 *         System.out.println("The first element in v1 is: " + v1.get(0));
 *         v3.set(0, -1);
 *         System.out.println("The first element in v1 is: " + v1.get(0));
 *         // 7. sort
 *         Collections.sort(v1);
 *         // 8. add new element at the end of the vector
 *         v1.add(-1);
 *         v1.add(1, 6);
 *         // 9. delete the last element
 *         v1.remove(v1.size() - 1);
 *     }
 * }
 *
 * @author Pubojian
 * @date 2020/3/15 22:52
 */
public class ArrayListMy{
    //默认初始容量
    private static final int DEFAULT_CAPACITY = 10;
    //
    transient Object[] elementData;
    //size
    private int size;
    //最大size
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //采用数组存储
    //get() 查O()
    //add() 增O(1)
    //remove() 删除 O(N)
    //et() 改
    //扩容1.5倍
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    //
    public Object clone() {
        //Arrays.copyOf()不仅仅只是拷贝数组中的元素，在拷贝元素时，会创建一个新的数组对象。
        //而System.arrayCopy只拷贝已经存在数组元素。
        //调用Arrays.copyOf()方法
        //Arrays.copyOf()调用System.arraycopy()方法
        return null;
    }

    //public ArrayList(Collection<? extends E> c) {
    //可以传入集合
    //所以复制时可以 new ArrayList<>(arrayList);

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        ArrayList list = new ArrayList(set);
        System.out.println(list);
        list.set(1, 7);
        System.out.println(list);
        ArrayList clone = (ArrayList) list.clone();
        clone.add(4);
        System.out.println(clone);
        System.out.println(list);

        int[] arr = {1, 2, 3};
        int[] arr1 = arr;
        int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);
        System.out.println(arr == arr2);
        System.out.println(arr.equals(arr2));
        System.out.println(arr == arr1);
        System.out.println(arr.equals(arr1));

        // "static void main" must be defined in a public class.
        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        // 2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        // 3. make a copy
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
        // 3. get length
        System.out.println("The size of v1 is: " + v1.size());;
        // 4. access element
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 5. iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); ++i) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 6. modify element
        v2.set(0, 5);       // modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 7. sort
        Collections.sort(v1);
        // 8. add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);
        // 9. delete the last element
        v1.remove(v1.size() - 1);
    }
}
