package com.spring.cg.exception;

public class PartyNotFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;
	private String message;

	public PartyNotFoundException() {
		this.message = "";
	}
	public PartyNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Party Not Found  " + this.message;
	}
}
