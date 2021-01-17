package com.spring.cg.service;

import java.time.LocalDate;
//import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.cg.utils.ElectionUtil;
import com.spring.cg.Myproperties;
import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.exception.InvalidStateException;
import com.spring.cg.json.Election;
import com.spring.cg.json.State;
import com.spring.cg.repo.ElectionRepo;
import com.spring.cg.repo.StateRepo;


@Service
public class ElectionServiceImpl implements ElectionService {

	private static final Logger logger = LogManager.getLogger(ElectionServiceImpl.class);
	

	@Autowired
	Myproperties properties;
	
	
	@Autowired
	private ElectionRepo electionrepo;
	
	@Autowired
	private StateRepo staterepo;
	
	
	
	@Override
	public Election createElection(Election election) throws InvalidStateException{							//Method For Creating New Election
		
		if(election!=null)
		{
			 if(staterepo.findAll().toString().contains(election.getState()))				//check whether Valid State is Presnt
			 {
			      
				ElectionEntity electionEntity = ElectionUtil.convertElectionIntoElectionEntity(election);
				electionEntity=electionrepo.save(electionEntity);										//Persist the Election into DataBase
				
				logger.info(properties.getLog().getSuccess()+" "+electionEntity.toString());			//Logger info
											
				return ElectionUtil.convertElectionEntityIntoElection(electionEntity);
			 }
			 else
			 {
				 logger.error("Invalid State"+election.getState());										//Logger Error
				 throw new InvalidStateException("Invalid state "+election.getState());					//Throws Exception for Invalid State
			 }
		}
		else {
			
			throw new NullPointerException(properties.getLog().getMandatory());						//Exception for Blank Fields
		}
		
	}
	

	@Override
	public List<Election> getAllElection() throws ElectionNotFoundException {					//Method To View All the Elections
		
		List<ElectionEntity> electionentity = electionrepo.findAll();
		
		if(electionentity.isEmpty())
		{
			logger.error("Election"+properties.getLog().getNotFound());
			throw new ElectionNotFoundException("No elections exist");							//Throws Exception if No Election Exist
		}
		else
		{
			logger.info("Election "+properties.getLog().getFound());
			logger.info(electionentity.toString());
			return  ElectionUtil.convertElectionEntityListIntoElectionList(electionentity);		//Data Retrieved Successfully
		}
	}


	@Override
	public List<State> getAllStates() {
		
		return  ElectionUtil.convertStateEntityListIntoStateList(staterepo.findAll());			//Method to Get ALL the States
	}
	
	
	
	@Override
	public List<Election> getAllElectionByState(String state) throws  ElectionNotFoundException{		//Method To View All Election By State
		
		
		
		List<ElectionEntity> electionEntity = electionrepo.findAllByState(state);
		if(electionEntity.isEmpty())
		{
			
			 logger.error(properties.getLog().getNoElection()+" state: "+state);
			 throw new ElectionNotFoundException(properties.getLog().getNoElection()+" state: "+state);		//Throws Exception If no Election for the state
		}
		else
		{
			
			logger.info("Elections "+properties.getLog().getFound()+" for state :"+state);
			logger.info(electionEntity.toString());
		
			return  ElectionUtil.convertElectionEntityListIntoElectionList(electionEntity);			//Returns Election Found for state
			
		}
		
	}

	
	
	@Override
	public List<Election> getAllElectionByElectionName(String electionName) throws ElectionNotFoundException {		//Method To View All Election By Election Name
		
		List<ElectionEntity> electionEntity = electionrepo.findAllByElectionName(electionName);
		if(electionEntity.isEmpty())
		{
			logger.error(properties.getLog().getNoElection()+" Election Name: "+electionName);
			 throw new ElectionNotFoundException(properties.getLog().getNoElection()+" Election Name: "+electionName);	//Throws Exception If no Election for the Election Name
		}
		else
		{
			logger.info("Elections "+properties.getLog().getFound()+" for election name :"+electionName);
			logger.info(electionEntity.toString());
			return  ElectionUtil.convertElectionEntityListIntoElectionList(electionEntity);					//Returns Election Found for Election Name
			
		}
		
		
		
	}

	
	@Override
	public List<Election> getAllElectionByDate(LocalDate date) throws ElectionNotFoundException {		//Method To View All Election By Election Date
		
		
		List<ElectionEntity> electionEntity = electionrepo.findAllByDate(date);
		if(electionEntity.isEmpty())
		{
			logger.error(properties.getLog().getNoElection()+" Date: "+date);
			 throw new ElectionNotFoundException("NO Elections for Date "+date);				//Throws Exception If no Election for the Election Date
		}
		else
		{
			logger.info("Elections "+properties.getLog().getFound()+" for Date :"+date);
			logger.info(electionEntity.toString());
			return  ElectionUtil.convertElectionEntityListIntoElectionList(electionEntity);				//Returns Election Found for Election Date
			
		}
		
	}
	
	
	@Override
	public List<Election> getAllElectionByConstituency(String constituency) throws ElectionNotFoundException {		//Method To View All Election By Constituency

		List<ElectionEntity> electionEntity = electionrepo.findAllByConstituency(constituency);
		if(electionEntity.isEmpty())
		{
			 logger.error(properties.getLog().getNoElection()+" Constituency: "+constituency);
			 throw new ElectionNotFoundException(properties.getLog().getNoElection()+" Constituency: "+constituency);	//Throws Exception If no Election for the Constituency
		}
		else
		{
			logger.info("Elections "+properties.getLog().getFound()+" for Constituency :"+constituency);
			logger.info(electionEntity.toString());
			return  ElectionUtil.convertElectionEntityListIntoElectionList(electionEntity);						//Returns Election Found for Constituency
			
		}
	}
	
	
	
	
	
	@Override
	public List<String> getAllElectionName() {
		// TODO Auto-generated method stub
		
		return electionrepo.getAllElectionName();
	}

	
	
	@Override
	public List<String> getAllElectionState() {
		// TODO Auto-generated method stub
		
		return electionrepo.getAllElectionState();
	}
	
	
	@Override
	public List<String> getAllConstituency() {
		// TODO Auto-generated method stub
		
		return electionrepo.getAllConstituency();
	}
	

	
	@Override
	public List<LocalDate> getAllDate() {
		// TODO Auto-generated method stub
		
		return electionrepo.getAllDate();
	}


	
	

	

	@Override
	public boolean deleteByElectionId(Long id) throws ElectionNotFoundException {					//Method To delete Election By Id
		// TODO Auto-generated method stub
				
				Optional<ElectionEntity> opElectionEntity = electionrepo.findById(id);
				
				if(opElectionEntity.isPresent())
				{
					
					 electionrepo.deleteById(id);
					 logger.info("Election deleted for Id :"+id);							//Return true id Election Deleted
					 return true;
				}
				else
				{
					logger.info("Election "+properties.getLog().getNotFound()+" for Id :"+id);
					throw new ElectionNotFoundException("Election not found for id :"+id);				//Exception throws if No Id found
				}
				
	}


	
	
	
	
			
	
	
	
	
}
