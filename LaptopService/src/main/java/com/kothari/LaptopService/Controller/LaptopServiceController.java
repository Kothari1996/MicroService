package com.kothari.LaptopService.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kothari.LaptopService.Entity.FullLaptopDetails;
import com.kothari.LaptopService.Entity.LaptopCompanys;
import com.kothari.LaptopService.Entity.laptopList;
import com.kothari.laptopServices.Exception.CompanyIDNotFoundException;
import com.kothari.laptopServices.Exception.ExceptionResponse;

@RestController
public class LaptopServiceController {

	@Autowired
	private LaptopCompanyRepository theLaptopCompanyRepository;

	@Autowired
	private LaptopListRepository theLaptopListRepository;

	@GetMapping("/Companys")
	public List<LaptopCompanys> getAllCompanyList() {
		// theGameListRepository.findAll();
		return theLaptopCompanyRepository.findAll();

	}

	@PostMapping("/newCompany")
	public void addCompanyName(@RequestBody LaptopCompanys theLaptopCompanys) {
		// theGameListRepository.findAll();
		theLaptopCompanyRepository.save(theLaptopCompanys);

	}

	@PostMapping("/Companys")
	public FullLaptopDetails getAllLapotopListByCompanyID(@RequestBody LaptopCompanys theLaptopCompanys) {
		int company_ID = theLaptopCompanys.getCompanyid();

		try {
			if (company_ID != 0) {

				Optional<LaptopCompanys> laptopID = theLaptopCompanyRepository.findById(company_ID);
				if (!laptopID.isPresent()) {
					throw new CompanyIDNotFoundException("Company ID not found : " + company_ID);
				}
				Map<String, Integer> uriVariable = new HashMap<>();
				uriVariable.put("company", company_ID);
				String laptopListurl = "http://localhost:8202/LaptopLists/";
				LaptopCompanys com = new LaptopCompanys();
				com.setCompanyid(company_ID);
				com.setCompanyname("");
				RestTemplate restTemplate = new RestTemplate();

				restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
				restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

				laptopList[] list = restTemplate.postForObject(laptopListurl, com, laptopList[].class, uriVariable);
				FullLaptopDetails full = new FullLaptopDetails();
				if (list == null) {
					return new FullLaptopDetails(null, laptopID);

				}
				return new FullLaptopDetails(list, laptopID);

			}

			else {
				ExceptionResponse ex = new ExceptionResponse();

				ex.setMessage("Company ID not found or value you provide is null  : " + company_ID);
				// ex.setMessage("njknjkfn");
				throw new CompanyIDNotFoundException(
						"Company ID not found or value you provide is null  : " + company_ID);
			}

		} catch (RuntimeException e) {
			throw new CompanyIDNotFoundException("Company ID Not found  :" + company_ID);

		}

	}

	@DeleteMapping("/Companys")
	public void deleteCompanyByID(@RequestBody LaptopCompanys theLaptopCompanys) {
		int companyID = theLaptopCompanys.getCompanyid();

		try {
			if (companyID != 0) {

				Optional<LaptopCompanys> checkCompanyID = theLaptopCompanyRepository.findById(companyID);

				if (!checkCompanyID.isPresent()) {
					throw new CompanyIDNotFoundException("Company ID not found  OR Already Deleted  -" + checkCompanyID);

				}
				
				else {
					Map<String, Integer> uriVariable = new HashMap<>();
					uriVariable.put("companyid", companyID);
					String laptopListurl = "http://localhost:8202/DeleteLaptopLists/";
					LaptopCompanys com = new LaptopCompanys();
					com.setCompanyid(companyID);
					com.setCompanyname("");
					RestTemplate restTemplate = new RestTemplate();

					restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
					restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

					ResponseEntity<laptopList> recorddeleted =restTemplate.postForEntity(laptopListurl, com, laptopList.class, uriVariable);
					if(recorddeleted==null) {
						theLaptopCompanyRepository.deleteById(companyID);
				}
				
				
			}
			}
			else 
				throw new CompanyIDNotFoundException("Company ID not found  OR invalid  -" + companyID);
			

		} catch (RuntimeException e) {
			throw new CompanyIDNotFoundException("Company ID Not found  :" + companyID);

		}

	}
	
}