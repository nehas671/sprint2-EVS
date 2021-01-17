package com.spring.cg.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.exception.InvalidUserDetails;
import com.spring.cg.json.Login;
import com.spring.cg.json.User;
import com.spring.cg.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value = "User realted RESt api")
public class UserController {

	@Autowired
	private UserService userService;
	
    private static final Logger logger = LogManager.getLogger(UserController.class);

   	
	//user login
		@ApiOperation(value = "user login")
		@ApiResponses(value= {
				@ApiResponse(code = 200,message = "Login successfully"),
				@ApiResponse(code = 402,message = "Login Failed")}
		)
		@PostMapping(value="/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Login> userLogin(@Valid @RequestBody Login login) throws InvalidDataException {
					Login login1=userService.userLogin(login);
					if(login1!=null)
					{
						logger.info( "Login successfully!");
						return new ResponseEntity<>(login1, HttpStatus.CREATED);
					}
					else
					{
						logger.info("Login Failed!!!");
						return new ResponseEntity<>(login1, HttpStatus.BAD_REQUEST);
					}
		}
			
		
		//update the password of user account
		@ApiOperation(value = "update users password")
		@ApiResponses(value= {
				@ApiResponse(code = 200,message = "Password updated successfully"),
				@ApiResponse(code = 404,message = "User does not exist with this emailId")}
		)
		@PutMapping(value = "/user/update/{emailId}/{password}", produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> updatePassword(@PathVariable(value="emailId") String emailId, 
				@PathVariable(value="password") String password, 
				@RequestBody String newpassword) throws InvalidDataException {
		
				User user=userService.updatePassword(emailId, password, newpassword);
				if(user!=null)
				{
					logger.info( "Password updated successfully!!");
					return new ResponseEntity<>(user, HttpStatus.CREATED);
				}
				else
				{
					logger.warn("User does not exist with this emailId!!!");
					return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
				}
		}
		
		
	}
