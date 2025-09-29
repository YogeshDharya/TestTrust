package com.example.geektrust.exception;

public class InvalidCommandException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String msg){
		super(msg);
	}
}
