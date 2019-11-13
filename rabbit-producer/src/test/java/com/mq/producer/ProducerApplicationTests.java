package com.mq.producer;

import com.mq.producer.config.RabbitSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RabbitProducer producer;

	@Test
	public void testStringSend() {
		for (int i = 0; i < 10; i++) {
			producer.stringSend();
		}
	}

	@Test
	public void testFanoutSend() {
		producer.fanoutSend();
	}

	@Test
	public void testTopic() {
		producer.topicTopic1Send();
		producer.topicTopic2Send();
		producer.topicTopic3Send();
	}

	@Test
	public void testDirect(){
		producer.directSendA();
		producer.directSendB();
	}



	@Autowired
	private RabbitSender rabbitSender;
	@Test
	public void testQueue2(){
		rabbitSender.sendOrder(new TestOrder("123","byb"),"springboot.abc");
	}
}
