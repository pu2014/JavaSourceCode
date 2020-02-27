package com.pu.basis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description：method : asList()
 *
 * @author Pubojian
 * @date 2020/2/27 17:18
 */
public class HowToUseArrays {
    public static void main(String[] args) {
        //two methods
        String[] arr = {"pu", "bo", "jian"};
        //1:
        List<String> list1 = Arrays.asList(arr);

        //2:本质是调用Arrays.asList(arr)
        /**
         * public static <T> List<T> asList(T... a) {
         *         return new ArrayList<>(a);
         *     }
         *
         *     ****注意！
         *     转换为list不能使用list的add/remove/clear方法
         *     因为用的是适配器模式，后台的数据依旧是数组。
         *
         *     返回的并不是java.util.ArrayList !而是java.util.Arrays.ArrayList
         *     private static class ArrayList<E> extends AbstractList<E>
         *         implements RandomAccess, java.io.Serializable
         *     {
         *         private static final long serialVersionUID = -2764017481108945198L;
         *         private final E[] a;
         *
         *         ArrayList(E[] array) {
         *             a = Objects.requireNonNull(array);
         *         }
         *
         *         @Override
         *         public int size() {
         *             return a.length;
         *         }
         *
         *         @Override
         *         public Object[] toArray() {
         *             return a.clone();
         *         }
         *
         *         @Override
         *         @SuppressWarnings("unchecked")
         *         public <T> T[] toArray(T[] a) {
         *             int size = size();
         *             if (a.length < size)
         *                 return Arrays.copyOf(this.a, size,
         *                                      (Class<? extends T[]>) a.getClass());
         *             System.arraycopy(this.a, 0, a, 0, size);
         *             if (a.length > size)
         *                 a[size] = null;
         *             return a;
         *         }
         *
         *         @Override
         *         public E get(int index) {
         *             return a[index]; //在数组中操作
         *         }
         *
         *         @Override
         *         public E set(int index, E element) {
         *             E oldValue = a[index];
         *             a[index] = element;
         *             return oldValue;
         *         }
         *
         *         @Override
         *         public int indexOf(Object o) {
         *             E[] a = this.a;
         *             if (o == null) {
         *                 for (int i = 0; i < a.length; i++)
         *                     if (a[i] == null)
         *                         return i;
         *             } else {
         *                 for (int i = 0; i < a.length; i++)
         *                     if (o.equals(a[i]))
         *                         return i;
         *             }
         *             return -1;
         *         }
         *
         *         @Override
         *         public boolean contains(Object o) {
         *             return indexOf(o) != -1;
         *         }
         *
         *         @Override
         *         public Spliterator<E> spliterator() {
         *             return Spliterators.spliterator(a, Spliterator.ORDERED);
         *         }
         *
         *         @Override
         *         public void forEach(Consumer<? super E> action) {
         *             Objects.requireNonNull(action);
         *             for (E e : a) {
         *                 action.accept(e);
         *             }
         *         }
         *
         *         @Override
         *         public void replaceAll(UnaryOperator<E> operator) {
         *             Objects.requireNonNull(operator);
         *             E[] a = this.a;
         *             for (int i = 0; i < a.length; i++) {
         *                 a[i] = operator.apply(a[i]);
         *             }
         *         }
         *
         *         @Override
         *         public void sort(Comparator<? super E> c) {
         *             Arrays.sort(a, c);
         *         }
         *     }
         */

        System.out.println(list1.size());
        List<String> list2 = Arrays.asList("pu", "bo", "jian");
        //class java.util.Arrays$ArrayList
        System.out.println(list2.getClass());

        System.out.println(list1.get(0));
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //System.out.println(list1.add("ai"));
        System.out.println(list2.get(0));

        /**
         * 当传入原生数据类型的数组是，asList的真正得到的参数就不是数组中的参数
         * 而是数组对象本身，此时list只要有一个元素，即数组本身
         *
         * 使用包装类就可以解决
         */
        int[] nums = {1,2,3};
        List list = Arrays.asList(nums);
        System.out.println(list.size());
        System.out.println(list.get(0));
        //[I@16d3586
        //1
        System.out.println(((int[])list.get(0))[0]);

    }
    /**
     *
     * Description:how to transform array to ArrayList
     * @auther
     */
    /**
     * 1：自己实现
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> arrayToList1(final T[] arr){
        final List<T> l = new ArrayList<>(arr.length);

        for(final T s : arr){
            l.add(s);
        }
        return l;
    }

    /**
     * 2最简单的方法
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> arrayToList2(final T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    /**
     * java8的Stream实现
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> arrayToList3(final T[] arr) {
        return Arrays.stream(arr).collect(Collectors.toList());
    }




}
