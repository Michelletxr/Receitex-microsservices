package com.br.receitex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReceitexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitexApplication.class, args);
	}

}
