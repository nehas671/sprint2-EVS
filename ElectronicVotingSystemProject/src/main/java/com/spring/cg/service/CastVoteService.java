package com.spring.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.spring.cg.json.State;
import com.spring.cg.exception.AlreadyVotedException;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.json.CastVote;

public interface CastVoteService 
{
	public CastVote createCastVote(CastVote castVote) throws AlreadyVotedException, CandidateNotFoundException;
	public List<CastVote> getCastVote(String election_name, String state, String constituency, LocalDate date) throws ElectionNotFoundException;
	public List<State> getAllStateName();
	public List<String> getAllElectionName();
}
