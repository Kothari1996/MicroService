package com.kothari.LaptopService.Entity;

import java.util.Arrays;
import java.util.Optional;

public class FullLaptopDetails {
	
	private laptopList[] laptopList;
	
	private Optional<LaptopCompanys> companyDetails;
	
	public FullLaptopDetails() {
		
	}

	public FullLaptopDetails(laptopList[] laptopList,
			Optional<LaptopCompanys> companyDetails) {
		super();
		this.laptopList = laptopList;
		this.companyDetails = companyDetails;
	}

	public laptopList[] getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(laptopList[] laptopList) {
	
		this.laptopList = laptopList;
	}

	public Optional<LaptopCompanys> getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(Optional<LaptopCompanys> companyDetails) {
		this.companyDetails = companyDetails;
	}

	@Override
	public String toString() {
		return "FullLaptopDetails [companyDetails =" +companyDetails + ", laptopList=" +  Arrays.toString(laptopList)
				+ "]";
	}



}
