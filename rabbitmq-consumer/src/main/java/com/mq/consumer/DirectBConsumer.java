package com.mq.consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutAConsumer
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/13 11:17
 * @Version 1.0.0
 **/
@Component
@RabbitListener(queues = "direct.b")
public class DirectBConsumer {
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[direct.b] recieved message:" + msg);
    }
}
