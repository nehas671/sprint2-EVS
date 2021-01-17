package com.spring.cg.service;

import java.util.List;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.json.Candidate;





public interface UpdateAndDeleteCandidateService {
	
	

		//To get Candidate details by Email
		public Candidate getCandidateByEmail(String email) throws  CandidateNotFoundException	;
		
	/*	
		//To Update Candidate Name by using Email
		Candidate updateCandidateName(String email, String candidate_name) throws CandidateNotFoundException;

		
		//To Update Candidate Address by using Email
		Candidate updateAddress(String email, String address) throws CandidateNotFoundException;

		
		//To Update Candidate Age by using Email
		Candidate updateAge(String email, int age) throws CandidateNotFoundException, InvalidAgeException;

		
		//To Update Candidate Contact Number by using Email
		Candidate updateContactNumber(String email, String contactNumber) throws CandidateNotFoundException;*/
		
		public Candidate updateCandidate(Integer id,Candidate candidate) throws CandidateNotFoundException;

		
		//To delete Candidate by using Email
		List<Candidate> deleteById(Integer id) throws CandidateNotFoundException;



}
 