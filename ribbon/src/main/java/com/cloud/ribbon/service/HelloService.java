package com.cloud.ribbon.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/5 10:35
 * @Version 1.0.0
 **/
@Service
public class HelloService {
    public String sayHello(){
        return "helloWorld"; // 提供一个hello World
    }
}
