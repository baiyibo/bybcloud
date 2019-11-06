package com.cloud.feign.service;

import com.cloud.feign.rpc.GetHello;
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
    GetHello getHello;
    public String sayHello(){
    return  getHello.sayHello();
    }
}
