package com.kothari.mainPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.kothari.mainPage.Controller.*")
@EnableDiscoveryClient
public class MainPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainPageApplication.class, args);
	}

}
