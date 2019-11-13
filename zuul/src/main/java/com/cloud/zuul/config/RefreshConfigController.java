package com.cloud.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RefreshConfigController
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/11 15:59
 * @Version 1.0.0
 **/
@RestController
@RefreshScope
public class RefreshConfigController {
    @Autowired
    private ConfigInfo configInfo;

    @GetMapping(value = "showConfigInfo")
    public Object showConfigInfo(){
        return configInfo;
    }

}
