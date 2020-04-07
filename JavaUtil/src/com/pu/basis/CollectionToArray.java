package com.pu.basis;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * description：Collection.toArray()是一个泛型方法，没有传递任何参数的话返回的是Object数组
 *
 * @author Pubojian
 * @date 2020/2/27 18:04
 */
public class CollectionToArray {
    public static void main(String[] args) {
        String[] str = new String[]{
                "pu", "bo", "jian"
        };
        List<String> list = Arrays.asList(str);
        Collections.reverse(list);
        //会报异常
        //str = list.toArray();

        str = list.toArray(new String[0]);
    }
}
