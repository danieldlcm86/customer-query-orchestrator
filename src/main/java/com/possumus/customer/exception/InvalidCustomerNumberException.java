package com.possumus.customer.exception;

public class InvalidCustomerNumberException extends RuntimeException {

	public InvalidCustomerNumberException(String message) {
		super(message);
	}

	public InvalidCustomerNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}
