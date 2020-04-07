package com.pu.operatingSystem.io.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 21:33
 */
public class NIOClient {
    /**
     * Non-blocking io 同步非阻塞的I/O模型
     * 1. io流是阻塞的，NIO非阻塞的
     * 2. IO面向流， NIO是面向缓冲区的
     * 3. NIO通过Channel进行读写，双向的，可读可写。流的读是单向的
     * 4. NIO 有选择器，单个线程处理多个通道。而IO没有
     * 5. 事件驱动模型 单线程处理多任务 IO复用
     *
     *
     * NIO在客户端的使用
     * 1： 每次连接顺序请求的Redis
     *      对于Redis来说,服务端全局串行，能够保证同一连接的所有请求与返回顺序一致
     *      可以使用单线程+队列，把请求数据缓存，然后pipeline发送，返回future，然后
     *      channel可读时，直接在队列中把future取回来，done()
     *
     * NIO 核心API：Channel Buffer Selector
     * JDK 的NIO底层时epoll实现，该实现的空轮询的bug会导致cpu飙升 -- Netty
     */
    public static void main(String[] args) {
        //todo 创建多个客户端连接服务器
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 5555);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
