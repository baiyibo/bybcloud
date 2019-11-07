package com.cloud.feign.rpc;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ribbon-provider",fallback = FeignClientFallback.class)
public interface GetHello {

//    @HystrixCommand(fallbackMethod = "fallback") //#方法级别的熔断回滚
    @RequestMapping(value = "/hello?name=feign",method = RequestMethod.GET)
    public String sayHello();
}