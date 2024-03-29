package com.bhx.global.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends NetflixException{

	private static final long serialVersionUID = -5330068136795055851L;

	public BadRequestException(final String message) {
		super(HttpStatus.BAD_REQUEST.value(), message);
	}

}
