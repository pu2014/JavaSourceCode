package com.pu.basis;

/**
 * description：String如何创建对象
 *
 * @author Pubojian
 * @date 2020/2/27 20:57
 */
public class NewString {
    public static void main(String[] args) {
        //todo 此时先去常量池找"a"，找不到"a",创建一个"a",返回引用值，
        // 所以可能创建0-1个对象
        String str = "a";
        //todo 此时先在对上new一个"b",返回引用。字符串拘留常量池。
        // 然后看常量池是否有该对象，
        // 没有就创建。所以可以创建1-2个对象
        String s = new String("b");
        String s2 = "b";
        String s3 = "b";
        System.out.println(s == s2); //false, 一个指向堆，一个指向常量池。
        System.out.println(s3 == s2);//true 地址一致



    }
}
