package com.sapient.exception;

public class EmailNotSentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailNotSentException(Throwable cause) {
		super(cause);
	}

}
