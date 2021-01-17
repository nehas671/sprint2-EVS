package com.spring.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.entity.CastVoteEntity;
import com.spring.cg.entity.ElectionsEntity;
import com.spring.cg.exception.AlreadyVotedException;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.json.CastVote;
import com.spring.cg.json.State;
import com.spring.cg.repo.CastVoteRepository;
import com.spring.cg.repo.ElectionRepository;
import com.spring.cg.repo.StateRepo;
import com.spring.cg.utils.CastVoteUtil;

@Service
public class CastVoteServiceImpl implements CastVoteService
{
	private static final Logger logger = LogManager.getLogger(CastVoteServiceImpl.class);
	@Autowired
	private CastVoteRepository castVoteRepo;
	
	@Autowired
	private ElectionRepository electionRepo;
	
	@Autowired
	private StateRepo staterepo;
	
	@Override
	public CastVote createCastVote(CastVote castVote) throws AlreadyVotedException, CandidateNotFoundException 
	{
		int count=0;
		List<CastVoteEntity> castVoteCandidateCheck = castVoteRepo.getAllCastVote(castVote.getElectionName().toUpperCase(),castVote.getConstituency().toUpperCase(),castVote.getDate());
		for(CastVoteEntity cast:castVoteCandidateCheck)
		{
			if(!(castVote.getCandidateName().equalsIgnoreCase(cast.getCandidateName())))
			{
				continue;
			}
			else
			{
				if(!(castVote.getPartyName().equalsIgnoreCase(cast.getPartyName())))
				{
					continue;
				}
				else
				{
					count = 1;
					break;
				}
			}
		}
		if(count==1)
		{
			logger.info("Candidate was successfully found!");
			List<CastVoteEntity> castVoteEntityList = castVoteRepo.findAll(castVote.getElectionName().toUpperCase(),castVote.getConstituency().toUpperCase(),castVote.getDate(),castVote.getVoterId());
			if(castVoteEntityList.isEmpty())
			{
				logger.info("Casting vote successfully!");
				CastVoteEntity castVoteEntity = castVoteRepo.save(CastVoteUtil.convertCastVoteIntoCastVoteEntity(castVote));
				return CastVoteUtil.convertCastVoteEntityIntoCastVote(castVoteEntity);
			}
			else
			{
				logger.error("Voter has already casted their vote!");
				throw new AlreadyVotedException("You have already voted!");
			}
		}
		else
		{
			logger.info("Candidate entered is not in the list!");
			throw new CandidateNotFoundException("Selected candidate not in list!");
		}
	}
	
	@Override
	public List<CastVote> getCastVote(String election_name, String state, String constituency, LocalDate date) throws ElectionNotFoundException {
		List<ElectionsEntity> election = electionRepo.findAll(election_name.toUpperCase(),state.toUpperCase(),constituency.toUpperCase(),date);
		if(election.isEmpty())
		{
			logger.info("Entered election doesn't exist on given date!");
			throw new ElectionNotFoundException("No election schedule today!");
		}
		else
		{
			logger.info("Candidate List for given election is generated!");
			return CastVoteUtil.convertCastVoteEntityListIntoCastVoteList(castVoteRepo.getAllCastVote(election_name.toUpperCase(),constituency.toUpperCase(),date));
		}
	}
	
	@Override
	public List<State> getAllStateName() {
		return  CastVoteUtil.convertStateEntityListIntoStateList(staterepo.findAll());
	}
	
	public List<String> getAllElectionName()
	{
		return electionRepo.getAllElectionName();
	}
}