package com.kothari.mainPage.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kothari.mainPage.Entity.GameList;
import com.kothari.mainPage.Entity.ServiceLists;
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
	
	
	@DeleteMapping("/DeleteService/{id}")
	public void DeleteService(@PathVariable int id) {
		theServiceListService.deleteServiceById(id);
		
	}
	
	@GetMapping(path="/Games")
	public GameList Gaming() {
		Map<String,String> uriVariable = new HashMap<>();
		
		
		ResponseEntity<GameList> responseEntity = new RestTemplate().getForEntity("http://localhost:8101/", GameList.class,"Games");
		GameList allList = responseEntity.getBody();
		
		return allList;
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
