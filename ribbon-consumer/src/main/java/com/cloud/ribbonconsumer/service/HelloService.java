package com.cloud.ribbonconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    RestTemplate restTemplate;
    public String sayHello(){
        return restTemplate.getForObject("http://ribbon-provider/hello?name=zhangsanfeng",String.class);
    }
}
