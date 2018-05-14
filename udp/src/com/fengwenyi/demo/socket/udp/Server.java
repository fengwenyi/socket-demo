package com.fengwenyi.demo.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 服务器端，实现基于UDP的用户登录
 * @author Wenyi Feng
 */
public class Server {

    public static void main(String[] args) {

        try {
            /**
             * 接收数据
             */
            // 1、创建服务器端DatagramSocket，指定端口
            DatagramSocket datagramSocket = new DatagramSocket(9002);
            // 2、创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024]; // 创建字节数据，指定接收数据报的大小
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
            // 3、接收客户端发送的数据
            System.out.println("服务器端已经启动，等待客户端发送数据");
            datagramSocket.receive(datagramPacket); // 此方法在接收到数据报之前会一直阻塞
            // 4、读取数据
            String info = new String(data, 0, datagramPacket.getLength());
            System.out.println("我是服务器，客户端说：" + info);

            /**
             * 响应
             */
            // 1、定义客户端的地址、端口号、数据
            InetAddress inetAddress = datagramPacket.getAddress();
            int port = datagramPacket.getPort();
            byte[] data2 = "登录成功，欢迎你".getBytes();
            // 2、创建数据报
            DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length, inetAddress, port);
            // 3、响应客户端
            datagramSocket.send(datagramPacket2);
            // 4、关闭资源
            datagramSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
