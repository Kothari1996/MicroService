package com.kothari.mainPage.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameIDNotFoundException extends RuntimeException {
	

	public GameIDNotFoundException(String message) {
		super(message);
	}

}

