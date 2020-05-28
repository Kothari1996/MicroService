package com.kothari.gamesDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GamesDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesDetailsApplication.class, args);
	}

}
