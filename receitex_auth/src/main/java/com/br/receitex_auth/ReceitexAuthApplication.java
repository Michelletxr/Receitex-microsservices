package com.br.receitex_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class ReceitexAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitexAuthApplication.class, args);
	}

}
