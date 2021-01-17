package com.spring.cg.exception;

public class PartyssNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public PartyssNotFoundException() {
		this.message = "";
	}

	public PartyssNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "partyss Not Found  " + this.message;
	}
}

