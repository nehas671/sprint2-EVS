package com.spring.cg.exception;

public class InvalidStateException extends Exception {

	private String message;
	
	public InvalidStateException() {
		
		this.message = "";
	}


	@Override
	public String toString() {
		return "InvalidStateException [message=" + message + "]";
	}


	public InvalidStateException(String message) {
		super();
		this.message = message;
	}

	
	
	
}
