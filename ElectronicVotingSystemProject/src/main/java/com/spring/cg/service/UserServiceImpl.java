package com.spring.cg.service;


import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.UserEntity;
import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.json.Login;
import com.spring.cg.json.User;
import com.spring.cg.repo.UserRepo;
import com.spring.cg.utils.UserUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Override
	public User createUser(User user) {
		Optional<UserEntity> userEntity = userRepo.findByEmailId(user.getEmailId());
		if(!userEntity.isPresent()) {
			logger.debug("Regitering a user");
			UserEntity userEntity1 = userRepo.save(UserUtil.covertUserToUSerEntity(user));
			return UserUtil.convertUserEntityToUser(userEntity1);
		}else {
			logger.warn("User alredy exists !!!!");
			return null;
		}
	}
    
    
    
	//user login
		@Override
	public Login userLogin(@Valid Login login) throws  InvalidDataException{
		Optional<UserEntity> opuserEntity = userRepo.findByEmailId(login.getEmailId());
		
		if(opuserEntity.isPresent())
		{
			UserEntity userEntity = opuserEntity.get();
			
			int n=userEntity.getAttempts();
			if( n<3) {
					if(userEntity.getPassword().equals(login.getPassword())){
						if(userEntity.getRole().equals(login.getRole()))
						{
							return login;
						}
						else
						{
							throw new InvalidDataException("User With this Role Does Not Exits");
						}
					}else{
						userEntity.setAttempts(n+1);
						userEntity=userRepo.save(userEntity);
						logger.info("Invalid Password");
						throw new InvalidDataException("Invalid Password");
					}
			}else{
				logger.info("Reached maximum limit for login");
				logger.warn("Reached maximum limit for login your account has been locked");
				throw new InvalidDataException("Reached maximum limit for login");
			}			
		}
		else
		{
			logger.info("EmailId does not exits");
			throw new InvalidDataException("EmailId does not exits");

		}
	}
		
		
		//update password of users account
		@Override
		public User updatePassword(String emailId, String oldpassword, String newpassword) throws InvalidDataException {

			Optional<UserEntity> opuserEntity = userRepo.findByEmailId(emailId);
			if(opuserEntity.isPresent())
			{
				UserEntity userEntity = opuserEntity.get();
				if(userEntity.getPassword().equals(oldpassword))
				{
					logger.info("password updated");
					userEntity.setPassword(newpassword);
					userEntity=userRepo.save(userEntity);
					return UserUtil.convertUserEntityToUser(userEntity);
				}
				else
				{
					logger.error("current password is wrong:");
					throw new InvalidDataException("current password is wrong:");
				}
			}
			else
			{
					logger.warn("User does not exist with this emailId!!!");
					throw new InvalidDataException("Could not find any user with this emailId : " + emailId);
			}
		}


	

}
