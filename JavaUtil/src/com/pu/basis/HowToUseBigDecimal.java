package com.pu.basis;

import java.math.BigDecimal;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/27 17:03
 */
public class HowToUseBigDecimal {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        //false 精度丢失
        System.out.println(a == b);

        //how to use
        BigDecimal c = new BigDecimal(1.0);
        BigDecimal d = new BigDecimal(0.9);
        BigDecimal e = new BigDecimal(0.8);
        BigDecimal x = c.subtract(d);
        BigDecimal y = d.subtract(e);
        //false  自动装箱问题ComparisonOfPackagingClasses
        System.out.println(x == y);
        //true
        System.out.println(x.equals(y));
        //0
        System.out.println(x.compareTo(y));
        //1
        System.out.println(c.compareTo(d));
        //0
        System.out.println(c.compareTo(c));
        //-1
        System.out.println(d.compareTo(c));
        /**
         * 防止精度丢失 推荐使用 BigDecimal(String)方法构造
         */
        //保留几位小数 setScale()
        BigDecimal m = new BigDecimal("1.22333");
        System.out.println(m.setScale(3, BigDecimal.ROUND_HALF_DOWN));
    }
}
