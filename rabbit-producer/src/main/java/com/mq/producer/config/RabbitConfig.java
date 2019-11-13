package com.mq.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @ClassName RabbitConfig
 * @Description TODO
 * @Author BaiYiBo
 * @Date 2019/11/13 10:31
 * @Version 1.0.0
 **/
@Configuration
public class RabbitConfig {

    /**
     * 定义队列名
     */
    private final static String STRING = "simpleMsg";


    /**
     * 定义string队列
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue(STRING);
    }


    //=================== fanout 模式  ==================== fanout类型的Exchange路由规则非常简单，它会把所有发送到该Exchange的消息路由到所有与它绑定的Queue中。

    @Bean
    public Queue fanoutA() {
        return new Queue("fanout.a");
    }

    @Bean
    public Queue fanoutB() {
        return new Queue("fanout.b");
    }

    @Bean
    public Queue fanoutC() {
        return new Queue("fanout.c");
    }

    /**
     * 定义个fanout交换器
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将定义的fanoutA队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithA() {
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }

    /**
     * 将定义的fanoutB队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithB() {
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }

    /**
     * 将定义的fanoutC队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithC() {
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }




    //#################topic模式########################
//    前面讲到direct类型的Exchange路由规则是完全匹配binding key与routing key，但这种严格的匹配方式在很多情况下不能满足实际业务需求。topic类型的Exchange在匹配规则上进行了扩展，它与direct类型的Exchage相似，也是将消息路由到binding key与routing key相匹配的Queue中，但这里的匹配规则有些不同，它约定：
//
//    routing key为一个句点号“. ”分隔的字符串（我们将被句点号“. ”分隔开的每一段独立的字符串称为一个单词），如“stock.usd.nyse”、“nyse.vmw”、“quick.orange.rabbit”
//    binding key与routing key一样也是句点号“. ”分隔的字符串
//    binding key中可以存在两种特殊字符“*”与“#”，用于做模糊匹配，其中“*”用于匹配一个单词，“#”用于匹配多个单词（可以是零个）

    @Bean
    public Queue topiocA() {
        return new Queue("topic.a");
    }

    @Bean
    public Queue topicB() {
        return new Queue("topic.b");
    }

    @Bean
    public Queue topicC() {
        return new Queue("topic.c");
    }

    /**
     * 定义个topic交换器
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new TopicExchange("topicExchange");
    }

    /**
     * 将定义的topicA队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithA() {
        return BindingBuilder.bind(topiocA()).to(topicExchange()).with("topic.msg");
    }

    /**
     * 将定义的topicB队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithB() {
        return BindingBuilder.bind(topicB()).to(topicExchange()).with("topic.#");
    }

    /**
     * 将定义的topicC队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithC() {
        return BindingBuilder.bind(topicC()).to(topicExchange()).with("topic.*.z");
    }

    //direct模式  direct类型的Exchange路由规则也很简单，它会把消息路由到那些binding key与routing key完全匹配的Queue中。


    @Bean
    public Queue directA() {
        return new Queue("direct.a");
    }

    @Bean
    public Queue directB() {
        return new Queue("direct.b");
    }


    /**
     * 定义个direct交换器
     * @return
     */
    @Bean
    DirectExchange directExchange() {
        // 定义一个名为directExchange的directExchange交换器
        return new DirectExchange("directExchange");
    }

    /**
     * 将定义的directA队列与directExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingDirectExchangeWithA() {
        return BindingBuilder.bind(directA()).to(directExchange()).with("aaa");
    }

    /**
     * 将定义的directB队列与directExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingDirectExchangeWithB() {
        return BindingBuilder.bind(directB()).to(directExchange()).with("bbb");
    }




    @Bean
    public Queue Queue2() {
        return new Queue("queue-2");
    }
    /**
     * 定义个topic交换器
     * @return
     */
    @Bean
    TopicExchange topicExchangeForQueue2() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new TopicExchange("exchange-2");
    }

    /**
     * 将定义的topicA队列与topicExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingTopicExchangeWithQueue2() {
        return BindingBuilder.bind(Queue2()).to(topicExchangeForQueue2()).with("springboot.#");
    }
}

