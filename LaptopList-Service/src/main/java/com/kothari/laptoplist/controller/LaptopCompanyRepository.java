package com.kothari.laptoplist.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kothari.LaptopListService.Entity.LaptopCompanys;

@Repository
public interface LaptopCompanyRepository extends JpaRepository<LaptopCompanys,Integer> {

	//theLaptopCompanyRepository.findById(company_ID);
	@Query(value="SELECT n FROM LaptopCompanys n WHERE n.company_Id = ?1",nativeQuery = true)
	LaptopCompanys findByID(int id);
	
}
