package com.spring.cg.exception;

public class UserNotFoundException extends Exception{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String message;
public UserNotFoundException() {
	
}
public UserNotFoundException(String message) {
	super();
	this.message = message;
}

@Override
public String toString() {
	return   message;
}

}
