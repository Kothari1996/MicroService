package com.kothari.mainPage.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kothari.mainPage.DAO.ServiceListRepository;
import com.kothari.mainPage.Entity.ServiceLists;

@Service
public class ServiceListServiceImpI implements ServiceListService {

	@Autowired
	private ServiceListRepository theServiceListRepository;
	

	

	@Override
	public List<ServiceLists> getServiceLists() {
		// TODO Auto-generated method stub
		return theServiceListRepository.getServiceLists();
	}

	@Override
	public ServiceLists findServiceByID(int theServiceLists) {
		// TODO Auto-generated method stub
		Optional<ServiceLists> getServiceLists=theServiceListRepository.findServiceByID(theServiceLists);
		ServiceLists serviceLists=null;
		if(getServiceLists.isPresent()) {
			serviceLists= getServiceLists.get();
		}
		
		else {
			 throw new RuntimeException("Did not find employee id - "+theServiceLists);
		}
		return serviceLists;
	}

	@Override
	public void saveService(ServiceLists theServiceLists) {
		// TODO Auto-generated method stub
		theServiceListRepository.saveService(theServiceLists);
	}

	@Override
	public void deleteServiceById(int theServiceLists) {
		// TODO Auto-generated method stub
		theServiceListRepository.deleteServiceById(theServiceLists);
	}

	
}
