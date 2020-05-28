package com.kothari.mainPage.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kothari.mainPage.Entity.GameDescription;
import com.kothari.mainPage.Entity.GameList;
import com.kothari.mainPage.Entity.ServiceLists;
import com.kothari.mainPage.ExceptionHandle.GameIDNotFoundException;
import com.kothari.mainPage.Service.ServiceListService;

@RestController
public class MainPageController {
	@Autowired
	private ServiceListService theServiceListService;
	//@Autowired
	//private ServiceListLatestRepository theServiceListLatestRepository;
	
	@GetMapping("/demo")
	public List<ServiceLists> getServiceList()
	{
		return theServiceListService.getServiceLists();
	//	return theServiceListLatestRepository.findAll();
	}
	
	@PostMapping("/addServiceList")
	public void addList( @RequestBody ServiceLists ServiceLists)
	
	{
		theServiceListService.saveService(ServiceLists);
		
	}
	
	
	@PostMapping("/DeleteService")
	public void DeleteService( @RequestBody ServiceLists ServiceLists) {
		
		int serviceID =ServiceLists.getServiceID();
		theServiceListService.deleteServiceById(serviceID);
		
		
	}
	
	/*
	@DeleteMapping("/DeleteService/{id}")
	public void DeleteService(@PathVariable int id) {
		theServiceListService.deleteServiceById(id);
		
	}
	
	*/
	
	@GetMapping(path="/Games")
	public GameList[] Gaming() {
		//Map<String,String> uriVariable = new HashMap<>();
		RestTemplate  restTemplate = new RestTemplate();
		//List<GameList> gameList = (List<GameList>) restTemplate.getForObject("http://localhost:8101/Games", GameList.class);
		GameList[] responseEntity = restTemplate.getForObject("http://localhost:8101/Games", GameList[].class);
		//GameList allList = ((Object) responseEntity).getBody();
		
		return  responseEntity ;
	}
	
	/*
	@GetMapping(path="/Games/{gameID}")
	public GameDescription GamingByID(@PathVariable int gameID) {
		//Map<String,String> uriVariable = new HashMap<>();
		Map<String,Integer> uriVariable = new HashMap<>();
		uriVariable.put("gameID", gameID);
		RestTemplate  restTemplate = new RestTemplate();
		
		
		

		//List<GameList> gameList = (List<GameList>) restTemplate.getForObject("http://localhost:8101/Games", GameList.class);
		//ResponseEntity<GameDescription[]> responseEntity = restTemplate.getForEntity("http://localhost:8101/Games/", GameDescription[].class,uriVariable);
		//GameDescription responseEntity=responseEntity.getBody();
	//	GameDescription[] forObject = new ObjectMapper.readValue(restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", GameDescription[].class).getBody() , new TypeReference<List<GameDescription>>() {}).get(0);
		// new ObjectMapper.
		String gameService ="http://localhost:8101/Games/"+gameID+"";
		ObjectMapper mapper = new ObjectMapper();
		GameDescription getGameDesc = mapper.convertValue(restTemplate.getForObject(gameService, GameDescription.class), GameDescription.class);
		//GameDescription getGameDesc = mapper.convertValue(restTemplate.getForObject("http://localhost:8101/Games/1", GameDescription.class), GameDescription.class);
		
		return  new GameDescription(getGameDesc.getId(),getGameDesc.getRating(),getGameDesc.getDesciption(),getGameDesc.getNoOFDownload()) ;
	}
	
	*/
	
	@PostMapping(path="/Games")
	public GameDescription GamingByID(@RequestBody GameList gameList) {
		//Map<String,String> uriVariable = new HashMap<>();
		int gameID =gameList.getGameID();
		try {
		
				Map<String,Integer> uriVariable = new HashMap<>();
				uriVariable.put("gameID", gameID);
				RestTemplate  restTemplate = new RestTemplate();
				
				
				

				//List<GameList> gameList = (List<GameList>) restTemplate.getForObject("http://localhost:8101/Games", GameList.class);
				//ResponseEntity<GameDescription[]> responseEntity = restTemplate.getForEntity("http://localhost:8101/Games/", GameDescription[].class,uriVariable);
				//GameDescription responseEntity=responseEntity.getBody();
			//	GameDescription[] forObject = new ObjectMapper.readValue(restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", GameDescription[].class).getBody() , new TypeReference<List<GameDescription>>() {}).get(0);
				// new ObjectMapper.
				String gameService ="http://localhost:8101/Games/"+gameID+"";
				ObjectMapper mapper = new ObjectMapper();
				GameDescription getGameDesc = mapper.convertValue(restTemplate.getForObject(gameService, GameDescription.class), GameDescription.class);
				//GameDescription getGameDesc = mapper.convertValue(restTemplate.getForObject("http://localhost:8101/Games/1", GameDescription.class), GameDescription.class);
				
				return  new GameDescription(getGameDesc.getId(),getGameDesc.getRating(),getGameDesc.getDesciption(),getGameDesc.getNoOFDownload()) ;
		}
		catch(RuntimeException  e){
			throw new GameIDNotFoundException("Game ID Details  Not Found -" +gameID);
			
		}
	}
	
	@PostMapping("/Restraurants")
	public void Restraurants(){
		
		
	}
	@PostMapping("/Cabs")
	public void Cab(){
		
		
	}
	@PostMapping("/Laptops")
	public void Laptops(){
		
		
	}
	
	@PostMapping("/Grocessorys")
	public void Grocessory(){
		
		
	}
	@PostMapping("/ITCompanys")
	public void ITCompanys(){
		
		
	}
	
	

	
	
}
