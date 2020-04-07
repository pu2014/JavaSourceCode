package com.pu.jvm;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 23:14
 */
public class RuntimeDataArea {
    //运行时数据区域
    /**
     * 线程私有的：
     *      *程数计数器  切换线程  没有内存溢出
     *      *虚拟机栈   栈帧构成 局部变量表、操作数栈、动态链接、方法出口等信息
     *      *本地方法栈 虚拟机使用的Native方法服务  在HotSpot虚拟机中和java虚拟机栈2合1
     * 线程共享：
     *      *堆  存放对象实例（GC堆）：新生代：老年代：元空间（本机物理内存限制）
     *      *方法区  类信息、常量、静态常量
     *             * 运行时常量池
     *                  * 字面 ：Sring，final,基本数据类型，其他
     *                  * 符号 : 完全限定名 字段名称方法名称和描述符
     *      *直接内存
     *
     */
}
