package com.avocado.pizziotalktalk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoUserIdException extends RuntimeException {
	public NoUserIdException(String message) {
		super(message);
	}
}
