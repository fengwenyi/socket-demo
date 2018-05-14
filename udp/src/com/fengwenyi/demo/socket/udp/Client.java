package com.fengwenyi.demo.socket.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Wenyi Feng
 */
public class Client {

    public static void main(String[] args) {

        try {
            /**
             * 发送数据
             */
            // 1、定义服务器的地址、端口号、数据
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 9002;
            byte[] data = "用户名：admin；密码：123".getBytes();
            // 2、创建数据报，包含发送的数据信息
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, port);
            // 3、创建DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket();
            // 4、想服务器端发送数据报
            datagramSocket.send(datagramPacket);

            /**
             * 接收数据
             */
            // 1、接收响应的信息
            byte[] data2 = new byte[1024];
            DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length);
            // 2、接收服务器端数据
            datagramSocket.receive(datagramPacket2);
            // 3、读取数据
            String reply = new String(data2, 0, datagramPacket2.getLength());
            System.out.println("我是客户端，服务器端说：" + reply);
            // 4、关闭资源
            datagramSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
