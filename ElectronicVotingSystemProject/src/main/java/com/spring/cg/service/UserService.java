package com.spring.cg.service;

import javax.validation.Valid;

import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.json.Login;
import com.spring.cg.json.User;

public interface UserService {

	
	
	public User updatePassword(String emailId, String oldpassword, String newpassword) throws InvalidDataException;
	public Login userLogin(@Valid Login login) throws  InvalidDataException;
	public User createUser(@Valid User user);
	//public Login updatePassword(@Valid Login login, String newpassword) throws  InvalidDataException;
	

}
