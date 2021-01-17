package com.spring.cg.exception;

public class AlreadyExistNumberException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AlreadyExistNumberException() {
		this.message = "";
	}
	public AlreadyExistNumberException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Mobile Already Exist: " + this.message;
	
	}

}
