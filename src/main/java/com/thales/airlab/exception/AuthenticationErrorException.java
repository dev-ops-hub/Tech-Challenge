package com.thales.airlab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthenticationErrorException extends Exception {
	
	public AuthenticationErrorException(String message) {
		super(message);
	}
	
}
