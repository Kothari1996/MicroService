package com.kothari.mainPage.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kothari.mainPage.Entity.ServiceLists;

@Repository
public interface ServiceListRepository  {
	
	  List<ServiceLists> getServiceLists(); 
	
	 Optional<ServiceLists> findServiceByID(int theServiceLists);

	 void saveService(ServiceLists theServiceLists);
	 void deleteServiceById(int theServiceLists);

}
