package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.json.Election;
import com.spring.cg.json.State;
import com.spring.cg.repo.StateRepo;
import com.spring.cg.service.ResultService;
import com.spring.cg.testjson.Result;

@SpringBootTest
public class ResultControllerTest {
	@Autowired 
	Myproperties properties;
	
	@Autowired 
	StateRepo stateRepo;

	private static final Logger logger = LogManager.getLogger(ResultController.class); 
	

	
	@Test
	public void getCountVotesTest()   //to get the votes of the Candidate in election by electionName and StateName
	{
		logger.info(properties.getLog().getStart()+" get the votes of the Candidate in election by electionName and StateName");
		RestTemplate restTemplate = new RestTemplate();
		Result result[] = 
		restTemplate.getForObject(properties.getLog().getLocalhost()+"8091/evs/result/Lok sabha/Madhya Pradesh", 
			Result[].class);
		logger.info(result);
		assertNotNull(result);
		logger.info(properties.getLog().getEnd()+" get the votes of the Candidate in election by electionName and StateName");
	}
	
	

	@Test
	void testCountVotesByElectionNameAndState_ResultNotFoundException() //test resultNotFoundException by passing Invalid ElectionName and stateName to countVote
	{
		logger.info(properties.getLog().getStart()+properties.getLog().getException()+"ElectionName and statename");
		RestTemplate restTemplate = new RestTemplate();	
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
			restTemplate.getForEntity(properties.getLog().getLocalhost()+"8091/evs/result/Vidhan Sabha/Uttar Pradesh", Result[].class);
		});
		logger.error(exception.getMessage());
		logger.info(properties.getLog().getEnd()+properties.getLog().getException()+"ElectionName and statename");
	}
	
	
	@Test
	public void InsertResultTest()  //to insert the result of election in result table
	{
		logger.info(properties.getLog().getStart()+"insert the result of election in election table");
		RestTemplate restTemplate = new RestTemplate();
		Result rs=new Result("Raj sabha","Maharashtra",new Date(20/12/2020),"shalu","bjp","mumbai",120);
		Result result[] = 
		restTemplate.postForObject(properties.getLog().getLocalhost()+"8091/evs/result/Raj sabha/Maharashtra",rs,
			Result[].class);
		logger.info(result);
		assertNotNull(result);
		logger.info(properties.getLog().getEnd()+" insert the result of election in election table");
	}
	
	
	@SuppressWarnings({ "deprecation", "unlikely-arg-type" })
	@Test
	void testaddResult_ValidState()  //test valid state inserted into Result
	{
		logger.info(properties.getLog().getStart()+"test valid state inserted into Result");
		RestTemplate restTemplate = new RestTemplate();
		Result result =new Result("Lok sabha","Madhya Pradesh",new Date(20/12/2020),"shalu","bjp","mumbai",120);
		Result res[] = restTemplate.
				  postForObject("http://localhost:8091/evs/result/Lok sabha/Madhya Pradesh", result, Result[].class);
			assertTrue(stateRepo.findAll().toString().contains(result.getState()));
			logger.info(properties.getLog().getEnd()+"test valid state inserted into Result");
				
	}
		
	
	@Test
	public void testaddResult_NullFieldException()  // to test NullField Validator
	{ 
		logger.info(properties.getLog().getStart()+"test NullField Validator");
			RestTemplate restTemplate = new RestTemplate();	
			Result rs=new Result("Raj sabha","Maharashtra",new Date(20/12/2020),null,"bjp","mumbai",120);
			Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
				restTemplate.postForEntity(properties.getLog().getLocalhost()+"8091/evs/result/Raj sabha/Maharashtra",rs, Result[].class);
			});
			logger.error(exception.getMessage());
			logger.info(properties.getLog().getEnd()+"test NullField Validator");
		}
		
	
	
	
	@Test
	public void ViewResultTest()    //to view all result of elections{
	{
	logger.info(properties.getLog().getStart()+"view all Result of Eleection");
		RestTemplate restTemplate = new RestTemplate();
		Result result[] = 
		restTemplate.getForObject(properties.getLog().getLocalhost()+"8091/evs/result", 
			Result[].class);
		logger.info(result);
		assertNotNull(result);
		logger.info(properties.getLog().getEnd()+" view all Result of Eleection");
	}
	
	
	@Test
	public void ViewResultByStateNameTest() //get Result of election by State Name
	{
		logger.info(properties.getLog().getStart()+"View all Result By State Name");
		RestTemplate restTemplate = new RestTemplate();
		Result result[] = restTemplate.getForObject(properties.getLog().getLocalhost()+"8091/evs/result/statename/Maharashtra",Result[].class);
		logger.info(result);
		assertNotNull(result);
		logger.info(properties.getLog().getEnd()+"View all Result By State Name");
	}
	

	@Test
	void testviewResultByState_ResultNotFoundException()  //test resultNotFoundException by passing Invalid StateName
	{
		logger.info(properties.getLog().getStart()+properties.getLog().getException()+"StateName");
		RestTemplate restTemplate = new RestTemplate();	
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
			restTemplate.getForEntity(properties.getLog().getLocalhost()+"8091/evs/result/statename/punjabb", Result[].class);
		});
		logger.error(exception.getMessage());
		logger.info(properties.getLog().getEnd()+properties.getLog().getException()+"StateName");
		
	}
		

	
	@Test
	public void ViewResultByElectionNameTest() //View Result of Election By ElectionName
	{
		logger.info(properties.getLog().getStart()+"View Result of Election By ElectionName");
		RestTemplate restTemplate = new RestTemplate();
		Result result[] = 
		restTemplate.getForObject(properties.getLog().getLocalhost()+"8091/evs/result/electionname/Lok sabha", 
			Result[].class);
		logger.info(result);
		assertNotNull(result);
		logger.info(properties.getLog().getEnd()+"View Result of Election By ElectionName");
	}
	
	
	
	@Test
	void testviewResultByElectionName_ResultNotFoundException() //test resultNotFoundException by passing Invalid ElectionName
	{
		logger.info(properties.getLog().getStart()+properties.getLog().getException()+"ElectionName");
		RestTemplate restTemplate = new RestTemplate();	
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
			restTemplate.getForEntity(properties.getLog().getLocalhost()+"8091/evs/result/electionname/lok sabhaa ", Result[].class);
		});
		logger.error(exception.getMessage());
		logger.info(properties.getLog().getEnd()+properties.getLog().getException()+"ElectionName");
	}
	
	

	@Test
	public void ViewResultByPartyNameTest()  //view Result of election By PartyName
	{
		logger.info(properties.getLog().getStart()+"View Result of Election By PartyName");
		RestTemplate restTemplate = new RestTemplate();
		Result result[] = 
		restTemplate.getForObject(properties.getLog().getLocalhost()+"8091/evs/result/partyname/Bhartiya janta Party", 
			Result[].class);
		logger.info(result);
		assertNotNull(result);
		logger.info(properties.getLog().getEnd()+"View Result of Election By PartyName");
	}
	
	
	

	@Test
	void testviewResultByPartyName_ResultNotFoundException()  //test resultNotFoundException by passing Invalid PartyName
	{
		logger.info(properties.getLog().getStart()+properties.getLog().getException()+"PartyName");
		RestTemplate restTemplate = new RestTemplate();	
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
			restTemplate.getForEntity(properties.getLog().getLocalhost()+"8091/evs/result/partyname/Bhartiya", Result[].class);
		});
		logger.error(exception.getMessage());
		logger.info(properties.getLog().getEnd()+properties.getLog().getException()+"PartyName");
		
	}	
	
	
	@Test
	public void ViewStateTest() //view  All the States
	{
		logger.info(properties.getLog().getStart()+"view  All the States");
		RestTemplate restTemplate = new RestTemplate();
		State state[] = 
		restTemplate.getForObject(properties.getLog().getLocalhost()+"8091/evs/state", 
			State[].class);
		logger.info(state);
		assertNotNull(state);
		logger.info(properties.getLog().getEnd()+"view  All the States");
	}
	

	
	@Test
	   void testDeleteById() // test delete result by result id
	   {
		logger.info(properties.getLog().getStart()+"test delete result by result id");
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(properties.getLog().getLocalhost()+"8091/evs/result/582");	
			logger.info(properties.getLog().getEnd()+"test delete result by result id");
			
	   }
	
	
	@Test
	void testDeleteById_ResultNotFoundException() //test delete resultNotFoundException by passing Invalid resultid
	{
		logger.info(properties.getLog().getStart()+properties.getLog().getException()+"result id");
		RestTemplate restTemplate = new RestTemplate();	
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
			restTemplate.delete(properties.getLog().getLocalhost()+"8091/evs/result/990", Result[].class);
		});
		logger.error(exception.getMessage());
		logger.info(properties.getLog().getEnd()+properties.getLog().getException()+"result id");
	}
		
}



