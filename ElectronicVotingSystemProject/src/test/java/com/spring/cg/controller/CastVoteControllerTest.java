package com.spring.cg.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.cg.exception.AlreadyVotedException;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.json.CastVote;
import com.spring.cg.service.CastVoteService;

@SpringBootTest
class CastVoteControllerTest
{
	private static final Logger logger = LogManager.getLogger(CastVoteController.class);
	
	@Autowired
	private CastVoteService castVoteService;
	
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForBlankElectionName()
	{
		logger.info("[Start]Test to get candidate list with election name blank");
		//RestTemplate restTemplate = new RestTemplate();
		//Exception exception = 
				assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			LocalDate date = LocalDate.parse("2020-12-13");
			castVoteService.getCastVote("", "Maharasthra", "Mumbai", date);
		});
	}
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForInvalidElectionName()
	{
		assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			LocalDate date = LocalDate.parse("2020-12-13");
			castVoteService.getCastVote("Presidential Election", "Maharashtra", "Mumbai", date);
		});
	}
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForBlankState()
	{
		assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			castVoteService.getCastVote("Lok Sabha", "", "Mumbai", LocalDate.of(2020, 12, 13));
		});
	}
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForInvalidState()
	{
		assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			castVoteService.getCastVote("Lok Sabha", "Andaman&Nicobar", "Mumbai", LocalDate.of(2020, 12, 13));
		});
	}
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForBlankConstituency()
	{
		assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			castVoteService.getCastVote("Lok Sabha", "Maharashtra", "", LocalDate.of(2020, 12, 13));
		});
	}
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForInvalidConstituency()
	{
		assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			castVoteService.getCastVote("Lok Sabha", "Maharashtra", "London", LocalDate.of(2020, 12, 13));
		});
	}
	
	@Test
	void testGetCandidateList_ElectionNotFoundExceptionForInvalidDate()
	{
		assertThrows(ElectionNotFoundException.class,
				()->
		{ 
			castVoteService.getCastVote("Lok Sabha", "Maharashtra", "Mumbai", LocalDate.of(2020, 12, 18));
		});
	}
	
	@Test
	void testGetCandidateListSuccess() 
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CastVote[]> responseEntity = restTemplate.getForEntity("http://localhost:8082/evs/election/castvote/Lok Sabha/Maharasthra/Mumbai/"+LocalDate.of(2020, 12, 13), CastVote[].class);
		assertNotNull(responseEntity);
	}
	
	@Test
	void testCreateNewCastVote_CandidateNotFoundExceptionForInvalidCandidateName()
	{
		//RestTemplate restTemplate = new RestTemplate();
		assertThrows(CandidateNotFoundException.class,
				()->
		{ 
			castVoteService.createCastVote(new CastVote("Lok Sabha", "Maharashtra", "Mumbai", LocalDate.of(2020, 12, 13), "Rishabh", "BJP", 12));
		});
	}
	
	@Test
	void testCreateNewCastVote_CandidateNotFoundExceptionForInvalidPartyName()
	{
		//RestTemplate restTemplate = new RestTemplate();
		assertThrows(CandidateNotFoundException.class,
				()->
		{ 
			castVoteService.createCastVote(new CastVote("Lok Sabha", "Maharashtra", "Mumbai", LocalDate.of(2020, 12, 13), "ABC", "AAP", 12));
		});
	}
	
	@Test
	void testCreateNewCastVote_AlreadyVotedException()
	{
		//RestTemplate restTemplate = new RestTemplate();
		assertThrows(AlreadyVotedException.class,
				()->
		{ 
			castVoteService.createCastVote(new CastVote("Lok Sabha", "Maharashtra", "Mumbai", LocalDate.of(2020, 12, 13), "PQR", "BJP", 2));
		});
	}
	
	@Test
	void testCreateNewCastVoteSuccess()
	{
		RestTemplate restTemplate = new RestTemplate();
		CastVote castVote = new CastVote ("Lok Sabha", "Maharasthra", "Mumbai", LocalDate.of(2020, 12, 13), "saad", "Congress", 501);
		ResponseEntity<CastVote> responseEntityCastVote = restTemplate.postForEntity("http://localhost:8082/evs/election/castvote", castVote, CastVote.class);
		assertNotNull(responseEntityCastVote.getBody());
		assertNotNull(responseEntityCastVote.getBody().getVoterId());
	}
}
