package com.cloud.feign.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConfigInfo
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/11 16:05
 * @Version 1.0.0
 **/
@Component
@Data
@ConfigurationProperties(prefix = "data")
public class ConfigInfo {

    private String env;
    private String version;

}
