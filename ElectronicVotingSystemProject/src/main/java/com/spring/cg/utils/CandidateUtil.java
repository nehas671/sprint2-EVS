package com.spring.cg.utils;

import java.util.List;
import java.util.ArrayList;

import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.PartyEntity;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Party;

public class CandidateUtil {

	
	
	
	public static Candidate convertCandidateEntityIntoCandidate(CandidateEntity candidateEntity) {
		Party party = new Party(candidateEntity.getParty().getPartyName(), candidateEntity.getParty().getLeader(), 
				candidateEntity.getParty().getSymbol());
		Candidate candidate = new Candidate(candidateEntity.getCandidateId(), candidateEntity.getCandidateName(),
				candidateEntity.getAddress(), candidateEntity.getAge(),candidateEntity.getContactNumber(), candidateEntity.getEmail(), party);
		return candidate;
	}
	
	
	
	
	public static CandidateEntity convertCandidateIntoCandidateEntity(Candidate candidate, PartyEntity partyEntity) {
		return new CandidateEntity(candidate.getCandidateName(), candidate.getAddress(), candidate.getAge(),
				candidate.getContactNumber(), candidate.getEmail(), partyEntity);
	}
	
	
	
	
	public static List<Candidate> convertCandidateEntityListIntoCandidateList(List<CandidateEntity> candidateEntityList) {
		List<Candidate> candidates = new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(convertCandidateEntityIntoCandidate(candidateEntity));
		}
		return candidates;
	}
	
}
