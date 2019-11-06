package com.cloud.ribbon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;

@SpringBootTest
class RibbonApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	RibbonLoadBalancerClient client;

	@Test
	public void test(){
		for (int i = 0; i < 100; i++) {
			ServiceInstance instance = this.client.choose("ribbon-provider");
			System.out.println(instance.getHost() + ":" + instance.getPort());
		}
	}




}
