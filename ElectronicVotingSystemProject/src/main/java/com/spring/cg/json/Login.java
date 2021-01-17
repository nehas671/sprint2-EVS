package com.spring.cg.json;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


public class Login {

	
	
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="User's email id")
	@Email( message="Please provide a valid email address")
	private String emailId;
	
	@ApiModelProperty(value="User's password")
	@NotNull
	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$", message="Please provide a valid password as")
	private String password;
	
	@NotBlank
	@NotNull( message="Please provide a valid user_Roll")
	@ApiModelProperty(value="Role")
	private String Role;
	
	
	public Login() {
		super();
	}
	
	
	



	public Login(@NotBlank @NotNull @Email(message = "Please provide a valid email address") String emailId,
			@NotBlank @NotNull(message = "Please provide a valid user_Roll") String user_Roll,
			@NotNull @NotBlank @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", 
			message = "Please provide a valid password as") String password) 
	{
		super();
		this.emailId = emailId;
		this.password = password;
		this.Role= Role;
		
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}






	@Override
	public String toString() {
		return "Login [emailId=" + emailId + ", password=" + password + ", Role=" + Role + "]";
	}

	
	
	
	

	
}
