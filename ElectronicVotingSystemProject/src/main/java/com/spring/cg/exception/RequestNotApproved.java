package com.spring.cg.exception;

public class RequestNotApproved extends Exception{

	private String message;

	public RequestNotApproved() {
		this.message="";
	}

	public RequestNotApproved(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Request Not Approved" + this. message;
	}
	
}
