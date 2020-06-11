package com.citi.genesis.api.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GenesisKafkaJsonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenesisKafkaJsonConsumerApplication.class, args);
	}


}
