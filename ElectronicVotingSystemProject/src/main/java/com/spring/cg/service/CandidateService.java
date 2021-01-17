package com.spring.cg.service;

import java.util.List;

import com.spring.cg.exception.AlreadyExistEmailAndNumberException;
import com.spring.cg.exception.AlreadyExistEmailException;
import com.spring.cg.exception.AlreadyExistNumberException;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.RecordNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Party;

public interface CandidateService {
	
	
	public Candidate createCandidate(Candidate candidate) throws AlreadyExistEmailException, AlreadyExistNumberException, AlreadyExistEmailAndNumberException;
	
	public List<Candidate> getAllCandidates() throws RecordNotFoundException;
	
	public List<Candidate> getCandidateByCandidateName(String candidate_namr) throws CandidateNotFoundException;
	
	public List<Candidate> getCandidateByPartyName(String party_name) throws CandidateNotFoundException;
	
	public List<Party> getAllPartys();
	
	public List<Candidate> deleteCandidate(String candidate_name) throws CandidateNotFoundException;
	
	public Candidate deleteById(Integer candidate_id) throws CandidateNotFoundException;

	public List<String> getCandidateName();

	public List<String> getPartyName();

	public List<Candidate> getCandidateByEmail(String email) throws CandidateNotFoundException;

	public List<Candidate> getCandidateByNumber(String contact_number) throws CandidateNotFoundException;

	public List<String> getEmail();

	public List<String> getNumber();
	
}



