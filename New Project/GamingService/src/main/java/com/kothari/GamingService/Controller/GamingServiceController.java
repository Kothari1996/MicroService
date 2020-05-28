package com.kothari.GamingService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kothari.GamingService.Entity.GameList;

@RestController
public class GamingServiceController {
	
	@Autowired
	private GameListRepository theGameListRepository;
	
	@Autowired
	private GameDescriptionRepository theGameDescriptionRepository;
	
	@GetMapping("/Games")
	public GameList getAllGameList() {
		theGameListRepository.findAll();
		return new GameList(1,"DarkNight");
		
	}

}
