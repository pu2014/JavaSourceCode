package com.pu.basis;

/**
 * description：整型包装类值的比较
 * 1:所以包装类对象值的比较必须使用equals方法
 *
 * @author Pubojian
 * @date 2020/2/27 16:44
 */
public class ComparisonOfPackagingClasses {
    public static void main(String[] args) {

        /**
         * 当自动装箱时，调用的时Integer.valueOf(int num)方法
         *
         * Integer.valueOf():
         * low -128  high 127
         * public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         *
         */
        Integer a = 3;
        Integer b = 3;
        //true
        System.out.println(a == b);
        Integer x = 300;
        Integer y = 300;
        //false
        System.out.println(x == y);

        Integer m = new Integer(4);
        Integer n = new Integer(4);
        //false 新建的对象，内存地址不一样
        System.out.println(m == n);

        //所以，需要比较内容 equals方法 true/ true/true
        /**
         * public boolean equals(Object obj) {
         *         if (obj instanceof Integer) {
         *             return value == ((Integer)obj).intValue();
         *         }
         *         return false;
         *     }
         *     先判断是否都是Integer对象，再转换为int值做对比
         */
        System.out.println(m.equals(n));
        System.out.println(a.equals(b));
        System.out.println(x.equals(y));


    }
}
