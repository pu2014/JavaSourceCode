package com.pu.concurrency;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/13 21:11
 */
public class VolatieAtomicTest {
    private static volatile int count = 0;

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(()->{
                for(int j = 0; j < 1000; j++){
                    count++;
                }
            }).start();
        }
        System.out.println(count);
    }
}
