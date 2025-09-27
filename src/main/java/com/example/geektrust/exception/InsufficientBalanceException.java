package com.example.geektrust.exception;

public class InsufficientBalanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InsufficientBalanceException(String msg) {
		super(msg);
	}

}
