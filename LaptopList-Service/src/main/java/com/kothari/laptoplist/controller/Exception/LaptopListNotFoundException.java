package com.kothari.laptoplist.controller.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LaptopListNotFoundException extends RuntimeException {
	

	public LaptopListNotFoundException(String message) {
		super(message);
	
		
	}

}

