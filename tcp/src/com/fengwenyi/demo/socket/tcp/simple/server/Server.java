package com.fengwenyi.demo.socket.tcp.simple.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wenyi Feng
 */
public class Server {

    public static void main(String[] args) {
        try {
            // 创建服务端socket
            ServerSocket serverSocket = new ServerSocket(9001);
            // 监听
            System.out.println("******服务端即将启动*********");
            Socket socket = serverSocket.accept();
            // 获取数据
            InputStream inputStream = socket.getInputStream(); // 字节输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream); // 字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // 缓冲
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);
            }

            socket.shutdownInput();

            // 给客户端响应
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("登录成功，欢迎你");
            printWriter.flush();

            socket.shutdownOutput();

            // 关闭
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
