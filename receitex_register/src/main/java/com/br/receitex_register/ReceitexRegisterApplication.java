package com.br.receitex_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ReceitexRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitexRegisterApplication.class, args);
	}

}
