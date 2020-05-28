package com.kothari.mainPage.Service;

import java.util.List;

import com.kothari.mainPage.Entity.ServiceLists;

public interface ServiceListService {
	public  List<ServiceLists> getServiceLists(); 
	
	public ServiceLists findServiceByID(int theServiceLists);

	public void saveService(ServiceLists theServiceLists);
	public void deleteServiceById(int theServiceLists);

}
