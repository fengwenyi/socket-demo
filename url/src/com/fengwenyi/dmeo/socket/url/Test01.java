package com.fengwenyi.dmeo.socket.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Wenyi Feng
 */
public class Test01 {

    public static void main(String[] args) {
        String baseUrl = "https://fengwenyi.com";
        try {
            URL fengwenyi = new URL(baseUrl);
            URL url = new URL(fengwenyi, "/article.html?id=18");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            System.out.println("端口：" + url.getPort()); // -1
            /*
            public int getPort()获取此 URL的端口号。
            结果
            端口号，如果端口未设置，则为-1
            */
            System.out.println("文件路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("相对路径：" + url.getRef());
            System.out.println("查询字符串：" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
