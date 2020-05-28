package com.kothari.LaptopService.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LaptopCompanys implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyid;
	
	private String companyname;

	@OneToMany(mappedBy = "theLaptopCompanys", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JsonIgnore
	private List<laptopList> theLaptopList;

	public LaptopCompanys() {

	}

	public LaptopCompanys(int companyid, String companyname) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
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

	public List<laptopList> getTheLaptopList() {
		return theLaptopList;
	}

	public void setTheLaptopList(List<laptopList> theLaptopList) {
		this.theLaptopList = theLaptopList;
	}

	@Override
	public String toString() {
		return "LaptopCompanys [companyid=" + companyid + ", companyname=" + companyname + "]";
	}

	
}
