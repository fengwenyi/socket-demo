package com.fengwenyi.demo.socket.tcp.thread.server;

import java.io.*;
import java.net.Socket;

/**
 * @author Wenyi Feng
 */
public class ServerThread extends  Thread {

    // socket
    Socket socket = null;

    public ServerThread (Socket socket) {
        this.socket = socket;
    }

    // 操作
    @Override
    public void run() {
        super.run();

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;

        try {
            inputStream = socket.getInputStream(); // 字节输入流
            inputStreamReader = new InputStreamReader(inputStream); // 字符流
            bufferedReader = new BufferedReader(inputStreamReader); // 缓冲
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);
            }

            socket.shutdownInput();

            // 给客户端响应
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("登录成功，欢迎你");
            printWriter.flush();

            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            try {
                if (printWriter != null)
                    printWriter.close();
                if (outputStream != null)
                    outputStream.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
