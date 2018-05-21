package com.spring.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;

	public BaseException(String e, HttpStatus httpStatus) {
		super(e);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
