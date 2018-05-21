package com.spring.pojo;

import java.util.Date;

public class ErrorDetails {

	private String errorMessage;
	private Date timestamp;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.errorMessage = message;
		this.timestamp = timestamp;
		this.details = details;
	}

	public String getMessage() {
		return errorMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return getTimestamp() + " : " + getMessage() + " : " + getDetails();
	}
}