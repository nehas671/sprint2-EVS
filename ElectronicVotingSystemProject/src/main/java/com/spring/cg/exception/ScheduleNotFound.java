package com.spring.cg.exception;

public class ScheduleNotFound extends Exception{
	private String message;

	public ScheduleNotFound(String message) {
		super();
		this.message = message;
	}

	public ScheduleNotFound() {
		super();
	}

	@Override
	public String toString() {
		return "ScheduleNotFound [message=" + message + "]";
	}

}
