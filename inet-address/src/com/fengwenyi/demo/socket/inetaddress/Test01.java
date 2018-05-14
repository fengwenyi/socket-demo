package com.fengwenyi.demo.socket.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Wenyi Feng
 */
public class Test01 {

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名：" + inetAddress.getHostName());
            System.out.println("IP：" + inetAddress.getHostAddress());
            byte[] bytes = inetAddress.getAddress(); // 获取字节数组形式的IP地址
            System.out.println("字节数组形式的IP：" + Arrays.toString(bytes));
            System.out.println(inetAddress); // 直接输出InetAddress对象

            System.out.println("---------------------------");

            // 根据主机名获取InetAddress实例
            // InetAddress addressByName = InetAddress.getByName("byxy");
            // InetAddress addressByName = InetAddress.getByName("192.168.0.105");
            byte[] ip = {-64, -88, 0, -56};
            InetAddress addressByName = InetAddress.getByAddress(ip);
            System.out.println("计算机名：" + addressByName.getHostName());
            System.out.println("IP：" + addressByName.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
