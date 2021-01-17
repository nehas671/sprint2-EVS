package com.spring.cg.exception;

public class ElectionNotFoundException extends Exception{

	private String message;

	public ElectionNotFoundException() {
		this.message = "";
	}

	public ElectionNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ElectionNotFound [message=" + message + "]";
	}
	
	
}
