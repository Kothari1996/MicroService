package com.kothari.mainPage.Controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kothari.mainPage.Entity.GameList;

import feign.Headers;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "games-service")

public interface GamingServiceProxy {
	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/{Games}")
	public GameList getallGamesList(@PathVariable("Games") String Games);

	@GetMapping("/Games/{id}")
	public GameList getallGamesList(@PathVariable("id") int id);


@PostMapping("/Games")
@Headers("Content-Type: application/json")
public GameList addNewGame(@RequestBody GameList list);
}