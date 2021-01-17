package com.spring.cg.service;

import java.util.List;

import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.json.RegisterUser;



public interface RegisterUserService {

public RegisterUser createRegisterUser(RegisterUser registerUser);

public RegisterUser userLogin(String emailId,String password) throws InvalidDataException;

}
