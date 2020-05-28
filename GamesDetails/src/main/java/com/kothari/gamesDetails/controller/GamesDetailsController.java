package com.kothari.gamesDetails.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kothari.gamesDetails.Entity.GameDescription;
import com.kothari.gamesDetails.Exception.GameIDNotFoundException;


@RestController
public class GamesDetailsController {
	
	@Autowired
	private GameDescriptionRepository theGameDescriptionRepository;
	@GetMapping("/Games/allGamesDetails")
	public List<GameDescription> getAllGamesDetails() {
		return theGameDescriptionRepository.findAll();
		
	}
	
	@GetMapping("/Games/{gameID}")
	public GameDescription getDetailsBygameID(@PathVariable int gameID) {
		Optional<GameDescription> user = theGameDescriptionRepository.findById(gameID);
		if(!user.isPresent()) {
			throw new GameIDNotFoundException("id -"+gameID);
			
		}
		
		
		
		return user.get();
		
	}
	
	@PostMapping(path="/Games/allGamesDetails")
	public ResponseEntity<Object> createDetailsForNewGame(@RequestBody GameDescription GameDescription) {
		//User userSaved=service.save(user);
		GameDescription gameDetailsSaved=theGameDescriptionRepository.save(GameDescription);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(gameDetailsSaved.getId()).toUri();
		return  ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path="/Games/{gamesID}")
	public void deleteUser(@PathVariable int gamesID) {
		theGameDescriptionRepository.deleteById(gamesID);
		
		//if(user ==null) {
		//	throw new UserNotFoundException("id -"+id);
		//}
		
	}
	

}
