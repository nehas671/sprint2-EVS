package com.spring.cg.exception;

public class InvalidAgeException extends Exception {
	
private String message;
	
	public InvalidAgeException() {
		
		this.message = " The age should be greater than 25 and less than 100";
	}


	@Override
	public String toString() {
		return "InvalidAgeException [message=" + message + "]";
	}


	public InvalidAgeException(String message) {
		super();
		this.message = message;
	}


}
