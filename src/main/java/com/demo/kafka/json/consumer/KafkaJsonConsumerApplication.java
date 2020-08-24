package com.demo.kafka.json.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class KafkaJsonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaJsonConsumerApplication.class, args);
	}


}
