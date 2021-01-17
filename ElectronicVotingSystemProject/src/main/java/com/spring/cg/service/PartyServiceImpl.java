package com.spring.cg.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.utils.CandidateUtil;
import com.spring.cg.utils.ElectionUtil;
import com.spring.cg.utils.PartyUtil;
import com.spring.cg.Myproperties;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.entity.PartysEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.exception.PartyNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;
import com.spring.cg.repo.ElectionRepo;
import com.spring.cg.repo.PartyRepo;

@Service
public class PartyServiceImpl implements PartyService {
	
	private static final Logger logger = LogManager.getLogger(ElectionServiceImpl.class);


		@Autowired
		Myproperties properties;

	
		@Autowired
		private PartyRepo partyrepo;
		
		@Autowired
		private ElectionRepo electionrepo;
		
		
	@Override
	public Partys createParty(Partys party) {
		// TODO Auto-generated method stub
		
		
		PartysEntity partysEntity = PartyUtil.convertPartyIntoPartysEntity(party);
		
		partysEntity=partyrepo.save(partysEntity);
		return ElectionUtil.convertPartysEntityIntoParty(partysEntity);
		
	}


	@Override
	public List<Partys> getAllParties() {
	
		return   PartyUtil.convertPartysEntityListIntoPartyList(partyrepo.findAll());
	}


	@Override
	public List<Election> UpdateElection(@Valid Partys party) {
	
		
		String p= party.getParty_name();
		
		System.out.println("PartyName :"+p);
		List<ElectionEntity> electionParty = new ArrayList<ElectionEntity>();
		
		List<ElectionEntity> electionEntityOp = electionrepo.findAll();
		
		System.out.println("all election.... "+electionEntityOp);
		
			//ElectionEntity electionEntity = electionEntityOp.get();
			
	
			Set<PartysEntity> parties = new HashSet<PartysEntity>();
			parties.add(ElectionUtil.convertPartyIntoPartysEntity(party));
			for(ElectionEntity e:  electionEntityOp)
			{
				e.setParty(parties);
				electionParty.add(electionrepo.save(e));
			}
			

			
			return PartyUtil.convertElectionEntityListIntoElectionList(electionParty);	
		
	
		
		
		
		
	}
	
	
	
	
	/*********************Method To View Party By Party Name**********************/
	
	

	@Override
	public Partys getPartyByPartyName(String party_name) throws PartyNotFoundException {				
		Optional<PartysEntity> partyEntityOp = partyrepo.findById(party_name);
		if(partyEntityOp.isEmpty())
		{
			logger.error("No party found");
			 throw new PartyNotFoundException(properties.getLog()+" no party for  Party Name: "+party_name);	//Throws Exception If no Party for the Party Name
		}
		else
		{
			
			logger.info("Party "+properties.getLog().getFound()+" for party name :"+party_name);
			PartysEntity partyEntity = partyEntityOp.get();
			
			return ElectionUtil.convertPartysEntityIntoParty(partyEntity);
			//Returns Party Found for Party Name
			
		}
		
		
		
	}
	
	
	@Override
	public List<String> getPartyName() throws PartyNotFoundException{
		logger.info("return party name");
		return partyrepo.getByParty_name();
	}



	

	@Override
	public List<Partys> getAllPartyByLeaderName(String leader) throws  PartyNotFoundException{		//Method To View All Election By State
		
		
		
		List<PartysEntity> partyEntity = partyrepo.findByleader(leader);
		if(partyEntity.isEmpty())
		{
			
			
			 throw new PartyNotFoundException("No Leader found : "+leader);		//Throws Exception If no Election for the state
		}
		else
		{
			
			logger.info("Parties found for leader name ");
			logger.info(partyEntity.toString());
		
			return  PartyUtil.convertPartysEntityListIntoPartyList(partyEntity);			//Returns Election Found for state
			
		}
		
	}
	
	
	@Override
	public List<String> getLeaderName() throws PartyNotFoundException{
		logger.info("Return leader name");
		return partyrepo.getByleader();
	}


	
	@Override
	public List<Partys> getAllPartyBySymbol(String symbol) throws  PartyNotFoundException{		//Method To View All Election By State
		
		
		
		List<PartysEntity> partyEntity = partyrepo.findBysymbol(symbol);
		if(partyEntity.isEmpty())
		{
			
			 logger.error("No party found");
			 throw new PartyNotFoundException("No Party found for  Symbol : "+symbol);		//Throws Exception If no Election for the state
		}
		else
		{
			
			logger.info("Parties found for symbol");
			logger.info(partyEntity.toString());
		
			return  PartyUtil.convertPartysEntityListIntoPartyList(partyEntity);			//Returns Election Found for state
			
		}
		
	}


	
	
	
	@Override
	public List<String> getSymbol() throws PartyNotFoundException{
		logger.info("return symbol");
		return partyrepo.getBySymbol();
	}


	
}
