package com.spring.cg.utils;

import java.util.ArrayList;
import java.util.List;

import com.spring.cg.entity.RegisterUserEntity;
import com.spring.cg.entity.ResultEntity;
import com.spring.cg.json.RegisterUser;
import com.spring.cg.json.Result;

public class RegisterUserUtil {

	public static List<RegisterUser> convertRegisterUserEntityListIntoRegisterUserList(List<RegisterUserEntity> registetUserEntityList) {
		List<RegisterUser> register = new ArrayList<RegisterUser>();
		for(RegisterUserEntity registerEntity: registetUserEntityList) {
			register.add(convertRegisterUserEntityIntoRegisterUser(registerEntity));
		}
		return register;
	}
	
	
	

	public static RegisterUser convertRegisterUserEntityIntoRegisterUser(RegisterUserEntity registerUserEntity) //Method to convert resultEntity class into result class
	{
			return new RegisterUser(registerUserEntity.getApplication_id(),registerUserEntity.getName(),registerUserEntity.getDob(),
					
					registerUserEntity.getEmailId(),registerUserEntity.getPassword(),registerUserEntity.getGender(),
					registerUserEntity.getMobile_number(),registerUserEntity.getAddress(),
					registerUserEntity.getDistrict()
					);
	}
	
	

public static RegisterUserEntity convertRegisterUserIntoRegisterUserEntity(RegisterUser registeruser) {
	
	return new RegisterUserEntity(registeruser.getApplication_id(),registeruser.getName(),registeruser.getDob(),
			registeruser.getEmailId(),registeruser.getPassword(),registeruser.getGender(),registeruser.getMobile_number(),
			registeruser.getAddress(),registeruser.getDistrict());
	


}
}
