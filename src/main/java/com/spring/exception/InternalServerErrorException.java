package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends BaseException {

	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String e) {
		super(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
