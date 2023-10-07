package com.br.receitex_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReceitexNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitexNotificationApplication.class, args);
	}

}
