package com.test.demo;

import com.test.consumer.DNConsumer;
import com.test.consumer.DNConsumerImpl;

public class ConsumerTest {
	
	public static void main(String[] args) {
		DNConsumer dnConsumer=new DNConsumerImpl();
		dnConsumer.init();
		dnConsumer.getMessage("DN-TEST-1");
	}

}
