package com.spring.cg.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.exception.InvalidDataException;
import com.spring.cg.json.RegisterUser;
import com.spring.cg.service.RegisterUserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/evs")
@CrossOrigin("*")
public class RegisterUserController {



@Autowired
private RegisterUserService registerUserService;



@PostMapping(value="/user",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RegisterUser> addNewUser(@RequestBody RegisterUser registeruser)
{

return new ResponseEntity<RegisterUser>(registerUserService.createRegisterUser(registeruser), HttpStatus.OK);

}


@ApiOperation(value = "user login")
@ApiResponses(value= {
		@ApiResponse(code = 200,message = "Login successfully"),
		@ApiResponse(code = 402,message = "Login Failed")}
)
@GetMapping(value="/user/{emailId}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RegisterUser> userLogin(@PathVariable(value="emailId") String emailId,
			@PathVariable(value="password") String password) throws InvalidDataException {
			RegisterUser user=registerUserService.userLogin(emailId, password);
			if(user!=null)
			{
				
				return new ResponseEntity<>(user, HttpStatus.CREATED);
			}
			else
			{
				
				
				return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
			}
}

}
