package com.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName RabbitProducer
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/13 10:36
 * @Version 1.0.0
 **/
@Component
public class RabbitProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void stringSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        System.out.println("[simpleMsg] send msg:" + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("simpleMsg", dateString);
    }

    public void fanoutSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        System.out.println("[fanout] send msg:" + dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey 我们不用管空着就可以，第三个是你要发送的消息
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", dateString);
    }



    public void topicTopic1Send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        dateString = "[topic.msg] send msg:" + dateString;
        System.out.println(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey topic.msg，第三个是你要发送的消息
        // 这条信息将会被 topic.a  topic.b接收
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.msg", dateString);
    }

    public void topicTopic2Send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        dateString = "[topic.good.msg] send msg:" + dateString;
        System.out.println(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey ，第三个是你要发送的消息
        // 这条信息将会被topic.b接收
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.good.msg", dateString);
    }

    public void topicTopic3Send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        dateString = "[topic.m.z] send msg:" + dateString;
        System.out.println(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey ，第三个是你要发送的消息
        // 这条信息将会被topic.b、topic.b接收
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.m.z", dateString);
    }



    public void directSendA() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        dateString = "[aaa] send msg:" + dateString;
        System.out.println(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey ，第三个是你要发送的消息
        // 这条信息将会被topic.b、topic.b接收
        this.rabbitTemplate.convertAndSend("directExchange", "aaa", dateString);
    }

    public void directSendB() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date);
        dateString = "[bbb] send msg:" + dateString;
        System.out.println(dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey ，第三个是你要发送的消息
        // 这条信息将会被topic.b、topic.b接收
        this.rabbitTemplate.convertAndSend("directExchange", "bbb", dateString);
    }

}
