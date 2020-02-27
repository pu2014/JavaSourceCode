package com.pu.program;

/**
 * description：
 *自己设计一个泛型的获取数组最小值的函数，并且这个方法只能接受numbers的子类并且实现Comparable接口。
 * @author Pubojian
 * @date 2020/2/27 18:19
 */
public class HowToDesignMinMethod {
    private static <T extends Number & Comparable<? super T>> T min(T[] values){
        if(values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 0; i < values.length; i++) {
            if(min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }
}
