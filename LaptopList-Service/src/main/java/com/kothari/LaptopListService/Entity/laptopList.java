package com.kothari.LaptopListService.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

public class laptopList  {
	@Id
	@Column(name="laptop_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int laptopId;
	private String laptopName;
	private String Description;
	private Long price;
	
	@ManyToOne
    @JoinColumn(name = "company_id")

	private LaptopCompanys company;
	
	public laptopList() {
		
	}

	
	
	

	public laptopList(int laptopId, String laptopName, String description, Long price, LaptopCompanys company) {
		super();
		this.laptopId = laptopId;
		this.laptopName = laptopName;
		Description = description;
		this.price = price;
		this.company = company;
	}





	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	
	@JsonBackReference
	public LaptopCompanys getCompany() {
		return company;
	}



	
	
	public void setCompany(LaptopCompanys company) {
		this.company = company;
	}





	@Override
	public String toString() {
		return "laptopList [laptopId=" + laptopId + ", laptopName=" + laptopName + ", Description=" + Description
				+ ", price=" + price + "]";
	}

	
	

}
