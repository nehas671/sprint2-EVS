package com.spring.cg.service;


import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.RegisterUserEntity;
import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.json.RegisterUser;
import com.spring.cg.repo.RegisterUserRepo;
import com.spring.cg.utils.RegisterUserUtil;



@Service
public class RegisterUserServiceImpl implements RegisterUserService {
private static final Logger logger = LogManager.getLogger(RegisterUserServiceImpl.class);
@Autowired
private RegisterUserRepo resgisterUserrepo;



@Override
public RegisterUser createRegisterUser(RegisterUser registerUser) {
// TODO Auto-generated method stub
RegisterUserEntity registerUserEntity = RegisterUserUtil.convertRegisterUserIntoRegisterUserEntity(registerUser);


registerUserEntity= resgisterUserrepo.save(registerUserEntity);
return RegisterUserUtil.convertRegisterUserEntityIntoRegisterUser(registerUserEntity);



}



@Override
public RegisterUser userLogin(String emailId, String password) throws InvalidDataException {
	// TODO Auto-generated method stub
	
	Optional<RegisterUserEntity> opuserEntity = resgisterUserrepo.findByEmailId(emailId);
	if(opuserEntity.isPresent())
	{
		RegisterUserEntity RegisterUserEntity = opuserEntity.get();
		logger.debug("user login");
		
		
				if(RegisterUserEntity.getPassword().equals(password)){
					return RegisterUserUtil.convertRegisterUserEntityIntoRegisterUser(RegisterUserEntity);
				}else{
					
					RegisterUserEntity=resgisterUserrepo.save(RegisterUserEntity);
					logger.info("Invalid Password");
					throw new InvalidDataException("Invalid Password");
				}		
	}
	else
	{
		logger.info("Login Failed");
		throw new InvalidDataException("Login Failed");

	}

	
}











}
