package com.spring.cg.utils;

import java.util.ArrayList;
import java.util.List;

import com.spring.cg.entity.CandidateEntity;

import com.spring.cg.entity.PartyEntity;

import com.spring.cg.json.Candidate;

import com.spring.cg.json.Party;


public class CandidatessUtil {
	
	public static CandidateEntity convertCandidateIntoCandidateEntity(Candidate candidate) {
		CandidateEntity candidateEntity = new CandidateEntity(candidate.getCandidateName(), candidate.getAddress(), candidate.getAge(),
				 candidate.getContactNumber(), candidate.getEmail());
		Party party = candidate.getParty();
		PartyEntity partyEntity= new PartyEntity(party.getPartyName(), party.getLeader(), party.getSymbol());
		candidateEntity.setParty(partyEntity);
		return candidateEntity;
	}
	
	public static Candidate convertCandidateEntityIntoCandidate(CandidateEntity candidateEntity) {
		PartyEntity partyEntity = candidateEntity.getParty();
		Candidate candidate = new Candidate(candidateEntity.getCandidateName(), 
				candidateEntity.getAddress(), candidateEntity.getAge(), candidateEntity.getContactNumber(), candidateEntity.getEmail());
		Party party = new Party(partyEntity.getPartyName(), partyEntity.getLeader(), partyEntity.getSymbol());
		candidate.setCandidateId(candidateEntity.getCandidateId());
		candidate.setParty(party);
		return candidate;
	}
	
	public static List<Candidate> convertCandidateEntityListIntoCandidateList(List<CandidateEntity> candidateEntityList) {
		List<Candidate> candidate = new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity: candidateEntityList) {
			candidate.add(convertCandidateEntityIntoCandidate(candidateEntity));
		}
		return candidate;
	}
	

}
