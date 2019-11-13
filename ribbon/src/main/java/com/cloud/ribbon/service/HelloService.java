package com.cloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/5 10:35
 * @Version 1.0.0
 **/
@Service
public class HelloService {
    @Autowired
    IpConfiguration ip;



    public String sayHello() throws InterruptedException {
//        Thread.sleep(7000);
        return ip.getPort()+" : helloWorld"; // 提供一个hello World
    }
}
