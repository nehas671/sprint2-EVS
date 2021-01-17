//package com.spring.cg.controller;
//
//
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.sql.Date;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestTemplate;
//
//
//import com.spring.cg.json.Election;
//import com.spring.cg.json.RegisterUser;
//import com.spring.cg.repo.RegisterUserRepo;
//import com.spring.cg.service.RegisterUserService;
//
//
//@SpringBootTest
//class RegisterUserControllerTest {
//	
//	@Autowired
//	private RegisterUserService registeruserService;
//	
//	@Autowired
//	private RegisterUserRepo registeruserrepo;
//
//	private static final Logger logger = LogManager.getLogger(RegisterUserControllerTest.class);
///*
//	@SuppressWarnings("deprecation")
//	@Test
//	public void addRegisterUserSuccess() {
//		
//		logger.info("entered into testcases");
//		RestTemplate restTemplate = new RestTemplate();
//		
//		//Calendar.set(year + 1900, month, date)
//				//RegisterUser user = new RegisterUser("date",  Calendar.set(2020 + 1900, 12, 28));
//		RegisterUser user = new RegisterUser("Dob",new Date(2020-1900,12,22-30));
//
//		ResponseEntity<RegisterUser> responseEntityRegisterUser = restTemplate.
//						  postForEntity("http://localhost:8080/evs/registeruser", user, RegisterUser.class);
//				logger.info(responseEntityRegisterUser);
//					assertNotNull(responseEntityRegisterUser.getBody().getRegisterUser_name());
//						
//				
//			}*/
//
//	@Test
//	
//
//	void testaddRegisterUser_InvalidDistrictException() {
//		
//		RegisterUser user = new RegisterUser(101, "Ram patil", new Date(2000,10,12), "patilram@gmail.com", 
//				"male", 6543217890L, "J.M.Road", "washim");
//			
//					
//					
//					registeruserService.createRegisterUser(user);
//					
//				
//	}
//	
//	
//	@Test
//	void testgetAllRegisterUser() {
//		RestTemplate restTemplate = new RestTemplate();
//		assertThrows(HttpClientErrorException.class,
//				()->{
//		ResponseEntity<RegisterUser[]> responseentity = restTemplate.getForEntity("http://localhost:9090/evs/user",RegisterUser[].class);
//		
//		assertNotNull(responseentity);
//		}
//		);
//		
//	}
//}
//	/*
//	@Test
//	void testgetAllRegisterUser_RegisterUserNotFoundException() {
//		RestTemplate restTemplate = new RestTemplate();
//		
//		     
//		
//		assertThrows(RegisterUserNotFoundException.class,
//				()->{
//					
//					
//					registeruserService.getAllRegisterUser();
//					
//				}
//				);
//	}*/
//	