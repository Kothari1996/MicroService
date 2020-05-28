package com.kothari.laptoplist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"com.kothari.LaptopListService.Entity"}) 
public class LaptopListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopListServiceApplication.class, args);
	}

}
