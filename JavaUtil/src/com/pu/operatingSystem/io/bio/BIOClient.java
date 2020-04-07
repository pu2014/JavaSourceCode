package com.pu.operatingSystem.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 18:30
 */
public class BIOClient {
    /**
     *  数据的读取写入必须阻塞在一个线程内等待其完成
     *
     *  同步：同步就是发起一个调用后，被调用者未处理完请求之前，调用返回
     * 异步：异步就是发起一个调用后，立刻得到被调用者的回应表示已经接受到请求，但是被调用者并没有返回结果
     *      此时我们可以处理其他请求，被调用者通常依靠事件，回调机制来通知调用者他的返回结果
     * 阻塞：当前线程挂起等待请求结果的返回
     * 非阻塞：发起一个请求，调用者不用一直等待结果返回，可以先去干其他事请
     */

    //伪异步IO
    /**
     * 后端通过一个线程池N来处理多个客户端请求接入
     * 防止海量并发接入导致线程耗尽
     */

    public static void main(String[] args) {
        //todo 创建多个客户端连接服务器
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while(true){
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
