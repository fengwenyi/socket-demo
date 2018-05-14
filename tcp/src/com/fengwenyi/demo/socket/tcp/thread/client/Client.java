package com.fengwenyi.demo.socket.tcp.thread.client;

import java.io.*;
import java.net.Socket;

/**
 * @author Wenyi Feng
 */
public class Client {

    public static void main(String[] args) {
        try {
            // 客户端socket
            Socket socket = new Socket("127.0.0.1", 9001);
            // 发送信息
            OutputStream outputStream = socket.getOutputStream(); // 字节输出流
            PrintWriter printWriter = new PrintWriter(outputStream); // 打印流
            printWriter.write("用户名：admin；密码：admin");
            printWriter.flush();

            // printWriter.close(); // 关闭输出流，导致socket关闭，因此不能关闭输出流

            /*
            传输对象
            User user = new User("admin", 20);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user); // 系列化
            */

            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String data = null;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println("我是客户端，服务器说：" + data);
            }

            socket.shutdownInput();

            // 关闭资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 总结，不用关闭输入/出（I/O）流，直接最后关闭socket就行
    }

}
