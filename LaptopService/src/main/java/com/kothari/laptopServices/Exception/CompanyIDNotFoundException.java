package com.kothari.laptopServices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.qos.logback.classic.Logger;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyIDNotFoundException extends RuntimeException {
	

	public CompanyIDNotFoundException(String message) {
		super(message);
	
		
	}

}

