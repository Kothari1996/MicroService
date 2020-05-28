package com.kothari.mainPage.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ServiceLists {
	@Id
	@Column(name="service_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ServiceID;
	
	@Column(name="service_name")
	private String ServiceName;

	
	protected ServiceLists() {
		
	}
	public ServiceLists(int serviceID, String serviceName) {
		super();
		ServiceID = serviceID;
		ServiceName = serviceName;
	}



	public int getServiceID() {
		return ServiceID;
	}

	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}

	public String getServiceName() {
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	@Override
	public String toString() {
		return "ServiceLists [ServiceID=" + ServiceID + ", ServiceName=" + ServiceName + "]";
	}
	
	

}
