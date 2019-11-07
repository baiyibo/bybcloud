package com.cloud.feign.rpc;

import org.springframework.stereotype.Component;

/**
 * @ClassName FeignClientFallback
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/6 15:00
 * @Version 1.0.0
 **/
@Component
public class FeignClientFallback implements GetHello {

    @Override
    public String sayHello() {
        return "hystrix回滚";
    }
}
