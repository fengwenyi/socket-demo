package com.fengwenyi.dmeo.socket.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Wenyi Feng
 */
public class Test02 {

    public static void main(String[] args) {
        // 使用url 读取网页内容
        String baseUrl = "https://fengwenyi.com";
        try {
            // url
            URL url = new URL(baseUrl);
            // 字节输入流
            InputStream inputStream = url.openStream();
            // 转为字符输入流
            // InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            // 缓冲
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取
            String data = bufferedReader.readLine();
            while (data != null) {
                System.out.println(data); // 当前行
                data = bufferedReader.readLine(); // 一行
            }
            // 关闭资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
