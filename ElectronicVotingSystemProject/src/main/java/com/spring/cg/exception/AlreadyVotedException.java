package com.spring.cg.exception;

public class AlreadyVotedException extends Exception
{
	private String message;

	public AlreadyVotedException() {
		this.message = "";
	}

	public AlreadyVotedException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "VoterAlreadyExists [message=" + message + "]";
	}
}
