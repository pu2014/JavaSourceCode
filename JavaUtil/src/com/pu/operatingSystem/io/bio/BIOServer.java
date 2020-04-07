package com.pu.operatingSystem.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 21:25
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        //接到客户端连接之和为每一个客户端建立一个新的线程进行链路处理
        new Thread(()->{
            while(true){
                try {
                    Socket socket = serverSocket.accept();

                    new Thread(()->{
                        int len;
                        byte[] bytes = new byte[1024];
                        try {
                            InputStream is = socket.getInputStream();
                            while((len = is.read(bytes)) != -1){
                                System.out.println(new String(bytes, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
