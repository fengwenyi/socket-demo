package com.fengwenyi.demo.socket.tcp.thread.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wenyi Feng
 */
public class Server {

    public static void main(String[] args) {
        final AtomicInteger count = new AtomicInteger(0);
        try {
            // 创建服务端socket
            ServerSocket serverSocket = new ServerSocket(9001);
            // 监听
            System.out.println("******服务端即将启动*********");
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count.getAndIncrement();
                System.out.println("客户端数量：" + count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端IP：" + inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
