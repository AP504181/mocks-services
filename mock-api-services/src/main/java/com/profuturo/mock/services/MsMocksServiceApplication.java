package com.profuturo.mock.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsMocksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMocksServiceApplication.class, args);
	}

}
