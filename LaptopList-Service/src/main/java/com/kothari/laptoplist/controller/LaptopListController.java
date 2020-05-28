package com.kothari.laptoplist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kothari.LaptopListService.Entity.LaptopCompanys;
import com.kothari.LaptopListService.Entity.laptopList;
import com.kothari.laptoplist.controller.Exception.LaptopListNotFoundException;


@RestController
public class LaptopListController {
	
	@Autowired
	private LaptopCompanyRepository theLaptopCompanyRepository;
	
	@Autowired
	private LaptopListRepository theLaptopListRepository;
	@GetMapping("/LaptopLists")
	public List<laptopList> allLaptopList()   {
		List<laptopList> AllCompanyLaptopList =theLaptopListRepository.findAll();
        return AllCompanyLaptopList;
			
		}
	
	
	@PostMapping("/LaptopLists")
	public List<laptopList> CompanyLaptopList(@RequestBody LaptopCompanys theLaptopCompanys) {
		
	//public List<laptopList> CompanyLaptopList(@PathVariable int companyid) {
		
	int companyid=theLaptopCompanys.getCompanyid();
		//System.out.println(companyid);
		try {
			if(companyid!=0) {
		Optional<LaptopCompanys>  CompanyOptional =theLaptopCompanyRepository.findById(companyid);
		
		
		if(CompanyOptional.isPresent()) {
			List<laptopList> laptopList = CompanyOptional.get().getLaptopLists();
			if(laptopList.isEmpty()) {
			
				return null;
			
		}
			else {
				//throw new LaptopListNotFoundException("Laptop List not found for Company id : "+companyid);
				
				return laptopList;
			}
		}
		else {
			throw new LaptopListNotFoundException("Laptop List not found for Company id : "+companyid);
		}
		
			}
		else {
			throw new LaptopListNotFoundException(" Company id is null or invalid :"+companyid);
			
			
		}
		}
			
			catch(LaptopListNotFoundException ex){
				throw new LaptopListNotFoundException(" Company id is null or invalid or not found data for this company id :" +companyid);
				
				
			}
		
	}
	
	
	
	@PostMapping("/addNewLaptopList")
	public void addNewLaptop(@RequestBody laptopList theLaptopList) {
		int companyid = theLaptopList.getCompany().getCompanyid();
		Optional<LaptopCompanys>  CompanyOptional =theLaptopCompanyRepository.findById(companyid);
		
		
		if(CompanyOptional.isPresent()) {
			LaptopCompanys company = CompanyOptional.get();
			theLaptopList.setCompany(company);
		theLaptopListRepository.save(theLaptopList);
		if(theLaptopList.getDescription().isEmpty() ) {
			theLaptopList.setDescription(null);
			
		}
		else if(theLaptopList.getPrice().toString().isEmpty()){
			theLaptopList.setPrice(null);
			
			
		}
		
		//return new laptopList(theLaptopList.getLaptopId(),theLaptopList.getLaptopName(),theLaptopList.getDescription(),theLaptopList.getPrice(),theLaptopList.()) ;
		
	}
		else {
			throw new LaptopListNotFoundException(" Company id is null or invalid or not found data for this company id :" +companyid);
			
			
		}
	}
		@PostMapping("/DeleteLaptopLists")
		public Optional<laptopList> DeletelaptopFromLaptopList(@RequestBody LaptopCompanys theLaptopCompanys)    {
			//LaptopCompanys laptopcompanyid = thelaptopList.getCompany();
			int companyid =theLaptopCompanys.getCompanyid();
			System.out.println("companyid :" +companyid);
			try {
			if(companyid!=0) {
				
				Optional<laptopList> laptoplistByCompany=	theLaptopListRepository.findById(companyid);
					if(!laptoplistByCompany.isPresent()) {
						throw new LaptopListNotFoundException("Laptop List not found that associcate with companyID  : " +companyid);
						
					}
					
					else {
						
							theLaptopListRepository.DeleteByCompanyID(companyid);
							return null;
						}
					
					}
				
				
			
			else {
				throw new LaptopListNotFoundException("Company ID is Not Found  : " +companyid);
				
			}
			
				
			}
			catch(LaptopListNotFoundException e) {
				throw new LaptopListNotFoundException("Company ID or Laptop Listis Not Found  : " +companyid);
				
			}
			
	
		
		
		
	}

}
