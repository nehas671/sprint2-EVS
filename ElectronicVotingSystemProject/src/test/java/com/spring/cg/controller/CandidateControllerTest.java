package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.Myproperties;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Party;

@SpringBootTest
class CandidateControllerTest {
	
	
	private static final Logger logger = LogManager.getLogger(CandidateControllerTest.class);
	
	@Autowired
	Myproperties properties;
	
	/*
	 *  ---------------------------------------------- TEST CANDIDATE DATA INSERTED SUCCESSFULLY ---------------------------------------------------------------------- 
	 **/
	
	@Test
	void testPostCandidateSuccess() {
		logger.info("[START] testPostCandidateSuccess()");
	
		RestTemplate restTemplate = new RestTemplate();
		Party party= new Party("AAP", "Arvind Kejriwal","Broom");
		Candidate cand =new Candidate(1, "Kajal", "Kolkata", 34, "9199900001", "kajal@gmail.com", party);
		Candidate candidate = restTemplate.postForObject(properties.getLog().getLocalhost()+ "8080/evs/candidate",cand, Candidate.class);
		assertNotNull(candidate);
		
		logger.info("[END] testPostCandidateSuccess()");
	}
	
	/*
     * ----------------------------------------- TEST CANDIDATE DATA IS NOT INSERTED SUCCESSFULLY BY PASSING INVALID INPUTS --------------------------------------------- 
     **/
	
	@Test
	void testPostCandidateFail() {
		
		logger.info("[START] testPostCandidateFail()");
		RestTemplate restTemplate = new RestTemplate();
		
		Party party= new Party("AAP", "Arvind Kejriwal","Broom");
		Candidate cand =new Candidate(-1, "", "", 34, "9199900001", "abc@gmail.com", party);
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate. postForObject(properties.getLog().getLocalhost()+"8080/evs/candidate", cand, Candidate.class);	
					
				}
				);
		
		logger.error(exception.getMessage());
		logger.info("[END] testPostCandidateFail()");
	}

	/*
	 * ----------------------------------------------- TEST BlankFieldException BY PASSING BLANK VALUES ------------------------------------------------------------------------
	 */
	
	@Test
	void testPostCandidate_BlankFieldException() {
		logger.info("[START] testPostCandidate_BlankFieldException()");
		RestTemplate restTemplate = new RestTemplate();
		
		Party party= new Party("AAP", "Arvind Kejriwal","Broom");
		Candidate cand =new Candidate(1, "", "", 34, "9199900001", "abc@gmail.com", party);
	    Exception exception =assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					 restTemplate.
							  postForObject(properties.getLog().getLocalhost()+"8080/evs/candidate", cand, Candidate.class);	
					
				});
	    logger.error(exception.getMessage());
		logger.info("[END] testPostCandidate_BlankFieldException()");
	}
	
	/*
	 * ----------------------------------------------- TEST NullFieldException BY PASSING NULL VALUES ------------------------------------------------------------------------ 
	 */
	
	@Test
	void testPostCandidate_NullFieldException() {
		logger.info("[START] testPostCandidate_NullFieldException()");
		RestTemplate restTemplate = new RestTemplate();
		
		Party party= new Party("AAP", "Arvind Kejriwal","Broom");
		Candidate cand =new Candidate(1, null, null, 34, "9199900001", "abc@gmail.com", party);
	    Exception exception =assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					 restTemplate.
							  postForObject(properties.getLog().getLocalhost()+"8080/evs/candidate", cand, Candidate.class);	
					
				});
	    logger.error(exception.getMessage());
		logger.info("[END] testPostCandidate_NullFieldException()");
	}
	
	
	
	
	/*
	 *  -------------------------------------------- TEST ALL CANDIDATE DATA VIEWED SUCCESSFULLY --------------------------------------------------------------------------
     **/
	
	@Test
	void testGetAllCandidate() {
		logger.info("[START] testGetAllCandidate()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity(properties.getLog().getLocalhost() + "8080/evs/candidate",Candidate[].class);
		assertNotNull(responseEntity);
		
		logger.info("[END] testGetAllCandidate()");
	}


	
	
	/*
	 * ----------------------------------------- TEST CANDIDATE DATA IS VIEWED SUCCESSFULLY BY PASSING EXISTING CANDIDATE NAME --------------------------------------------- 
     **/
	
	@Test
	void testGetCandidateByCandidateNameSuccess() {
		logger.info("[START] testGetCandidateByCandidateNameSuccess()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity(properties.getLog().getLocalhost() + "8080/evs/candidate/Raj",Candidate[].class);
	
		assertNotNull(responseEntity);
		
		logger.info("[END] testGetCandidateByCandidateNameSuccess()");
	}
	
	/*
	 *  ----------------------------------------- TEST CandidateNotFoundException BY PASSING NON-EXISTING CANDIDATE NAME ----------------------------------------------------
     **/
	
	@Test
	void testGetCandidateByCandidateNameFail() {	
		RestTemplate restTemplate = new RestTemplate();
		logger.info("[START] testGetCandidateByCandidateNameFail()");
		
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate. getForEntity(properties.getLog().getLocalhost()+"8080/evs/candidate/Koma" , Candidate[].class);	
					
				}
				);
		logger.error(exception.getMessage());
		logger.info("[END] testGetCandidateByCandidateNameFail()");
	}
	
	
	
	
	/*
	 *  ---------------------------------------- TEST CANDIDATE DATA IS VIEWED SUCCESSFULLY BY PASSING EXISTING PARTY NAME --------------------------------------------------
     **/
	
	@Test
	void testGetCandidateByPartyNameSuccess() {
		logger.info("[START] testGetCandidateByPartyNameSuccess()");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Candidate[]> responseEntity = restTemplate.getForEntity(properties.getLog().getLocalhost() + "8080/evs/candidate/party/Congress",Candidate[].class);
	
		assertNotNull(responseEntity);
		
		logger.info("[END] testGetCandidateByPartyNameSuccess()");
	}
	
	/*
	 *  --------------------------------------- TEST CandidateNotFoundException BY PASSING NON-EXISTING PARTY NAME -----------------------------------------------------------
     **/
	
	@Test
	void testGetCandidateByPartyNameFail() {	
		RestTemplate restTemplate = new RestTemplate();
		logger.info("[START] testGetCandidateByPartyNameFail() ");
		
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate. getForEntity(properties.getLog().getLocalhost()+"8080/evs/candidate/party/BJ" , Candidate[].class);	
					
				}
				);
		logger.error(exception.getMessage());
		
		logger.info("[END] testGetCandidateByPartyNameFail() ");
	}
	
	
	
	
	
	/*
	 *  --------------------------------------- TEST CANDIDATE DATA DELETED SUCCESSFULLY BY PASSING EXISTING CANDIDATE NAME ---------------------------------------------
	 **/
	
	@Test()
	void testDeleteCandidateByCandidateName() {
		logger.info("[START] testDeleteCandidateByCandidateName()");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/evs/candidate/{candidate_name}/delete/", "Kajal");
		
		logger.info("[END] testDeleteCandidateByCandidateName()");
		
		
	}
	
	/*
     *  --------------------------------------- TEST CANDIDATE DATA NOT DELETED SUCCESSFULLY BY PASSING NON-EXISTING CANDIDATE NAME ----------------------------------------
     **/
	
	@Test()
	void testDeleteCandidateByCandidateNameFail() {
		RestTemplate restTemplate = new RestTemplate();
		logger.info("[START] testDeleteCandidateByCandidateNameFail()");
		
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate. delete(properties.getLog().getLocalhost()+"8080/evs/candidate/{candidate_name}/delete/" , "Kaja");	
					
				}
				);
		logger.error(exception.getMessage());
		
		logger.info("[END] testDeleteCandidateByCandidateNameFail()");
	}
	
	
	
	
	/*
	 * ---------------------------------------------  TEST CANDIDATE DATA DELETED SUCCESSFULLY BY PASSING EXISTING CANDIDATE ID --------------------------------------------- 
	 **/
	
    @Test
	public void testDeleteCandidateByCandidateIdSuccess() 
	 {
    	logger.info("[START] testDeleteCandidateByCandidateIdSuccess()");
    	
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(properties.getLog().getLocalhost() + "8080/evs/candidate/delete/{candidate_id}",255);
		
		logger.info("[END] testDeleteCandidateByCandidateIdSuccess()");
		
	 }
    
    /*
     * ---------------------------------------------- TEST CANDIDATE DATA NOT DELETED SUCCESSFULLY BY PASSING NON-EXISTING CANDIDATE ID --------------------------------------
     **/
    
    @Test()
	void testDeleteCandidateByCandidateIdFail()
	 {
    	RestTemplate restTemplate = new RestTemplate();
    	logger.info("[START] testDeleteCandidateByCandidateIdFail()");
    	
    	Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class,
				()->{
					
					restTemplate. delete(properties.getLog().getLocalhost()+"8080/evs/candidate/delete/{candidate_id}" , -1);	
					
				}
				);
		logger.error(exception.getMessage());
		
		logger.info("[END] testDeleteCandidateByCandidateIdFail()");
	}
}
