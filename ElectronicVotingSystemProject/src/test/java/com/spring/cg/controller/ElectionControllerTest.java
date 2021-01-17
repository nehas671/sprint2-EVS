package com.spring.cg.controller;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.spring.cg.Myproperties;
import com.spring.cg.json.Election;
import com.spring.cg.repo.StateRepo;



@SpringBootTest
class ElectionControllerTest {
	
	@Autowired
	Myproperties properties;
	
	@Autowired
	private StateRepo staterepo;
	
	
	
	private static final Logger logger = LogManager.getLogger(ElectionControllerTest.class);

	
	

	/*------------------Test case for Adding Election Details-[Pass]--------------*/
	
	
	@Test
	public void addElectionSuccess() {
		
		logger.info("[START] addElectionSuccess()");
		
		RestTemplate restTemplate = new RestTemplate();
		Election election = new Election("Loksabha","Maharashtra","Pune",LocalDate.of(2021, 02, 15));
		Election responseEntityElection = restTemplate.postForObject(properties.getLog().getLocalhost()+"8080/evs/election", election, Election.class);
		assertNotNull(responseEntityElection.getElection_name());
		
		logger.info("[END] addElectionSuccess()");
		
	}
	
	
	/*------------------Test case for Adding Valid State for Election-[Pass]--------------*/
	@Test
	void testaddElection_ValidState() {
		RestTemplate restTemplate = new RestTemplate();
		
		logger.info("[START] testaddElection_ValidState()");
		
		Election election = new Election("Loksabha","Kerala","lucknow",LocalDate.of(2021, 01, 13));
		Election responseEntityElection = restTemplate.postForObject(properties.getLog().getLocalhost()+"8080/evs/election", election, Election.class);
		assertTrue(staterepo.findAll().toString().contains(responseEntityElection.getState()));	
			
		logger.info("[END] testaddElection_ValidState()");	
	}
	
	
	/*------------------Test case for Adding InvalidValid State for Election-[Fail]--------------*/
	@Test
	void testaddElection_InvalidState() {
		
		logger.info("[START] testaddElection_InvalidState()");
		
		RestTemplate restTemplate = new RestTemplate();
		
		Election election = new Election("Loksabha","USA","lucknow",LocalDate.of(2021, 01, 13));
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
			()->{
					
				restTemplate. postForObject(properties.getLog().getLocalhost()+"8080/evs/election", election, Election.class);	
		
			});
		logger.error(exception.getMessage());
		logger.info("[END] testaddElection_InvalidState");
	}
	
	
	
	
	/*------------------Test case for Adding Election with Blank Fields -[Fail]--------------*/
	@Test
	void testaddElection_BlankFieldException() {
		logger.info("[START] testaddElection_BlankField");
		RestTemplate restTemplate = new RestTemplate();
		
		Election election = new Election(" "," ","lucknow",LocalDate.of(2021, 01, 13));
	Exception exception =assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					 restTemplate.postForObject(properties.getLog().getLocalhost()+"8080/evs/election", election, Election.class);	
					
				});
	    logger.error(exception.getMessage());
		logger.info("[END] testaddElection_BlankField()");
	}
	
	
	/*------------------Test case for Adding Election with Null Fields -[Fail]--------------*/
	@Test
	void testaddElection_NullField() {
		logger.info("[START] testaddElection_NullField()");
		
		RestTemplate restTemplate = new RestTemplate();
		Election election = new Election(null,null,null,LocalDate.of(2021, 01, 13));
		
		Exception exception =assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					 restTemplate. postForObject(properties.getLog().getLocalhost()+"8080/evs/election", election, Election.class);		
				});
	 	logger.error(exception.getMessage());
	 	
		logger.info("[END] testaddElection_NullField()");
	}
	
	
	
	
	
	/*------------------Test case for Viewing All Elections--[Pass]--------------*/

	@Test
	void testgetAllElection() {
		logger.info("[START] testgetAllElection()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Election[]> responseEntity = restTemplate.getForEntity(properties.getLog().getLocalhost()+"8080/evs/election",Election[].class);
		assertNotNull(responseEntity);
		
		logger.info("[END] testgetAllElection()");
		
	}
	
	
	/*------------------Test case for Viewing All Elections By State--[Pass]--------------*/
	@Test
	void testgetElectionByState() {
		logger.info(" [START]  testgetElectionByState()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Election[]> responseEntity = restTemplate.getForEntity(properties.getLog().getLocalhost()+"8080/evs/election/state/Uttar Pradesh",Election[].class);
		
		assertNotNull(responseEntity);
		
		logger.info("[END] testgetElectionByState()");
		
	}
	
	
	/*------------------Test case for Viewing All Elections By State--[Fail]--------------*/
	@Test
	void testgetElectionByState_ElectionNotFound() {
		logger.info(" [START] testgetElectionByState_ElectionNotFound()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					 restTemplate.getForEntity(properties.getLog().getLocalhost()+"8080/evs/election/state/Punjab",Election[].class);	
				}
				);
		 logger.error(exception.getMessage());
		 logger.info("[END] testgetElectionByState_ElectionNotFound()");
	}
	
	
	/*----------------Test case for Viewing All Elections By Constituency--[Pass]--------------*/
	@Test
	void testgetElectionByConstituency() {
		
		logger.info(" [START] testgetElectionByConstituency()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Election[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/evs/election/constituency/lucknow",Election[].class);
		
		assertNotNull(responseEntity);
		
		 logger.info("[END] testgetElectionByConstituency()");
		
	}
	
	
	
	/*----------------Test case for Viewing All Elections By Constituency--[Fail]--------------*/
	@Test
	void testgetElectionByConstituency_ElectionNotFound() {
		logger.info(" [START] testgetElectionByConstituency_ElectionNotFound()");
		
		RestTemplate restTemplate = new RestTemplate();
		
		Exception exception =assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate.getForEntity(properties.getLog().getLocalhost()+"8080/evs/election/constituency/Akola",Election[].class);
					
				}
				);
		 logger.error(exception.getMessage());
		 
		 logger.info("[END] testgetElectionByConstituency_ElectionNotFound()");
	}
	
	
	
	/*----------------Test case for Viewing All Elections By Date--[Pass]--------------*/
	@Test
	void testgetElectionByDates() {
		logger.info(" [START] testgetElectionByDates()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Election[]> responseEntity = restTemplate.getForEntity(properties.getLog().getLocalhost()+"8080/evs/election/date/2020-12-22",Election[].class);
		assertNotNull(responseEntity);
		logger.info(" [END] testgetElectionByDates()");
		
	}
	
	
	/*----------------Test case for Viewing All Elections By Date--[Fail]--------------*/
	
	@Test
	void testgetElectionByDates_ElectionNotFound() { 
		logger.info(" [START] testgetElectionByDates_ElectionNotFound()");
		RestTemplate restTemplate = new RestTemplate();
		
		Exception exception =assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate.getForEntity(properties.getLog().getLocalhost()+"8080/evs/election/date/2021-07-25",Election[].class);
				}
				);
		logger.error(exception.getMessage());
		logger.info(" [END] testgetElectionByDates_ElectionNotFound()");
	}
	
	
	/*-------------------------Test Case for Deleting Election------------------*/
	 
		/*@Test
		void testDeleteElectionById() {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete("http://localhost:8080/evs/election/{id}",202);

		}*/
		

}
