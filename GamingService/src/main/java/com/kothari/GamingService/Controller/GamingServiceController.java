package com.kothari.GamingService.Controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kothari.GamingService.Entity.GameDescription;
import com.kothari.GamingService.Entity.GameList;
import com.kothari.gamesDetails.Exception.GameIDNotFoundException;

@RestController
public class GamingServiceController {
	
	@Autowired
	private GameListRepository theGameListRepository;
	
	@Autowired
	private GameDescriptionRepository theGameDescriptionRepository;
	
	@GetMapping("/Games")
	public List<GameList> getAllGameList() {
		//theGameListRepository.findAll();
		return theGameListRepository.findAll();
		
	}
	
	@GetMapping("/Games/{gameID}")
	public GameDescription getDetailsBygameID(@PathVariable int gameID) {
		Optional<GameList> gameList = theGameListRepository.findById(gameID);
		if(!gameList.isPresent()) {
			 throw new GameIDNotFoundException("id -"+gameID);
			
		}
		Map<String,Integer> uriVariable = new HashMap<>();
		uriVariable.put("gameID", gameID);
		
		String gamedetailservice ="http://localhost:8102/Games/"+gameID+"";
		RestTemplate  restTemplate = new RestTemplate();
		
		//List<GameList> gameList = (List<GameList>) restTemplate.getForObject("http://localhost:8101/Games", GameList.class);
		//Map<String,GameDescription> responseEntity = restTemplate.getForObject("http://localhost:8102/Games/1", Map.class);
		ObjectMapper mapper = new ObjectMapper();
		GameDescription getGameDesc = mapper.convertValue(restTemplate.getForObject(gamedetailservice, GameDescription.class), GameDescription.class);
		
		//List<GameDescription> theGameDescription = responseEntity.get("");
	
		
		//return //new GameDescription(responseEntity.getId(),responseEntity.getRating(),responseEntity.getDesciption(),responseEntity.getNoOFDownload());
		return getGameDesc;
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
