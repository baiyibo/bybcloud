package com.mq.consumer.RabbitConsumer;

import com.mq.producer.TestOrder;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName RabbitConsumer
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/13 15:51
 * @Version 1.0.0
 **/
@Service
public class RabbitConsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-2", durable = "true"),
            exchange = @Exchange(value = "exchange-2",
                    durable = "true", type = "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "springboot.#")
    )
    @RabbitHandler
    // @Payload 获取我们传输的数据，通过注解@Headers 获取消息请求头
    public void onOrderMessage(@Payload TestOrder order, @Headers Map<String, Object> properties, Channel channel) throws IOException {
        System.out.println("消费端 order:" + order);
        // deliveryTag: 对于每个Channel来说，每个消息都会有一个DeliveryTag，一般用接收消息的顺序(index)来表示，一条消息就为1
        Long deliveryTag = (Long) properties.get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("deliveryTag:" + deliveryTag);
        // 限流处理：消息体大小不限制，每次限制消费一条，只作用于该Consumer层，不作用于Channel
        //0表示对消息的大小无限制，1表示每次只允许消费一条，false表示该限制不作用于channel。
        channel.basicQos(0, 1, false);
        // 手工ACK,不批量ack，multiple:当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
        //deliveryTag表示处理的消息条数（一般为1），从heaers中取，false表示不批量ack。
        channel.basicAck(deliveryTag, false);
    }
}
