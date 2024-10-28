package org.example;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String address = "http://localhost:8080/calculator";
        Endpoint endpoint = Endpoint.publish(address, calculator);
        System.out.println("Calculator service published at " + address);

        // 为了保持服务运行，添加一个阻塞操作
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭服务
        endpoint.stop();
        System.out.println("Calculator service stopped.");
    }
}