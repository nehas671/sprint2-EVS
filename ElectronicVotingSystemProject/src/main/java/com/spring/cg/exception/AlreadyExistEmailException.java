package com.spring.cg.exception;

public class AlreadyExistEmailException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AlreadyExistEmailException() {
		this.message = "";
	}
	public AlreadyExistEmailException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Email Already Exist: " + this.message;
	
	}
}
