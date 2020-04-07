package com.pu.operatingSystem.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/6 22:13
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //serverSelector 负责轮询是否有新的连接，监测到新的连接时，不创建新的连接，
        // 而是直接绑定在 clientSelector 上
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(()->{
            try {
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(5555));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while(true){
                    //检测是否有新连接 1表示阻塞事件为1ms
                    if(serverSelector.select(1) > 0){
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while(keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isAcceptable()){
                                try {
                                    //来一个连接，直接注册到clientSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                }finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try{
                while(true){
                    //批量轮询是否有哪些连接有数据可以读取
                    if(clientSelector.select(1) > 0){
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while(keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();

                            if(key.isReadable()){
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                                    //面向buffer
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}
