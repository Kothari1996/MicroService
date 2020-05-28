package com.kothari.LaptopListService.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LaptopCompanys implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyid;
	
	private String companyname;

	@OneToMany(mappedBy = "company")
	//@JsonManagedReference
	//@JsonIgonre
	private List<laptopList> LaptopLists ;//=new ArrayList<laptopList>();

	protected LaptopCompanys() {

	}

	public LaptopCompanys(int companyid, String companyname) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
	}
	
	

	public LaptopCompanys(int companyid) {
		super();
		this.companyid = companyid;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	  @JsonManagedReference
	public List<laptopList> getLaptopLists() {
		return LaptopLists;
	}

	public void setLaptopLists(List<laptopList> laptopLists) {
		LaptopLists = laptopLists;
	}

	@Override
	public String toString() {
		return "LaptopCompanys [companyid=" + companyid + ", companyname=" + companyname + "]";
	}

	
}
