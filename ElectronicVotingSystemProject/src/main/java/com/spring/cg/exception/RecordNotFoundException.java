package com.spring.cg.exception;

public class RecordNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public RecordNotFoundException() {
		this.message = "";
	}
	public RecordNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Null Value Found  " + this.message;
	}
}