package com.kothari.laptoplist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kothari.LaptopListService.Entity.laptopList;

@Repository
public interface LaptopListRepository extends JpaRepository<laptopList,Integer> {

	@Query(value="SELECT n FROM laptop_list n WHERE n.company_Id = ?1",nativeQuery = true)
	List<laptopList> findBycompany_Id(int companyid);
	//List<laptopList> findAll(Integer companyID);findAllBycompanyId
	@Query(value="SELECT n FROM laptop_list n WHERE n.company_Id = ?1",nativeQuery = true)
	
	Optional<laptopList> findAllByCompayID(int companyid);
	
	
	
@Query(value="SELECT count(company_Id) FROM laptop_list n WHERE n.company_Id = ?1",nativeQuery = true)
	
	Long  CountByCompanyID(int companyid);
	
@Query(value="delete from laptop_list where company_Id=?1",nativeQuery = true)
void DeleteByCompanyID(int companyid);
	


}
