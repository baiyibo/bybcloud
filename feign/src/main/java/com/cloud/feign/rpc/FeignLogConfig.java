package com.cloud.feign.rpc;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignLogConfig
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/6 15:22
 * @Version 1.0.0
 **/
@Configuration
public class FeignLogConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
