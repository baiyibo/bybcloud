package com.cloud.feign.controller;

import com.cloud.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/5 10:40
 * @Version 1.0.0
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(String name){
        return helloService.sayHello() + " " + name;
    }
}
