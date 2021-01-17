
package com.spring.cg.exception;

public class ResultNotFoundException extends Exception //Custom Exception
{
	private String message;

	public ResultNotFoundException() //Default Constructor
	{
		super();
		this.message = "";
	}
	public ResultNotFoundException(String message)  //Parameterize Constructor
	{
		super();
		this.message = message;
	}


	@Override
	public String toString() 
	{
		return "ResultNotFoundException [message=" + message + "]";
	}
}






