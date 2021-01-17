package com.spring.cg.exception;

public class AlreadyExistEmailAndNumberException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AlreadyExistEmailAndNumberException() {
		this.message = "";
	}
	public AlreadyExistEmailAndNumberException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Email and Number Already Exist: " + this.message;
	
	}
}
