package com.pu.basis;

import java.util.Objects;

/**
 * description：equals方法的正确使用
 * 1. 不能被null调用
 * 2. 推荐使用Objects工具类
 *
 * @author Pubojian
 * @date 2020/2/27 16:33
 */
public class JavaEquals {

    public static void main(String[] args) {
        String str = null;
        //Exception in thread "main" java.lang.NullPointerException 空指针异常
        //System.out.println(str.equals("pu"));
        //false
        System.out.println("pu".equals(null));

        /**
         * 推荐用法  JDK7引入的工具类  java.util.Objects#equals
         * return: false
         *
         *  source code:
         * public static boolean equals(Object a, Object b) {
         *         return (a == b) || (a != null && a.equals(b));
         *     }
         */
        System.out.println(Objects.equals(null, "pu"));
    }
}
