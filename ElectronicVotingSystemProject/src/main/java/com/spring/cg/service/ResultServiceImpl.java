package com.spring.cg.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.Myproperties;
import com.spring.cg.entity.ResultEntity;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.json.Result;
import com.spring.cg.json.State;
import com.spring.cg.repo.ResultRepo;
import com.spring.cg.repo.StateRepo;
import com.spring.cg.utils.ResultUtil;


@Service
public class ResultServiceImpl implements ResultService {

	
	private static final Logger logger = LogManager.getLogger(ResultServiceImpl.class);		//Logger
	@Autowired
	private ResultRepo resultRepo;                  //ResultRepository

	@Autowired
	private StateRepo staterepo;					//StateRepository
  
	@Autowired
	Myproperties properties;
	@Override
	public List<Result> getResult(String electionname, String statename)throws ResultNotFoundException //Method to count Votes of an Election based on ElectionName And StateName
	{
		List<ResultEntity> resultEntity=resultRepo.getAllResult(electionname, statename);
		if(resultEntity.isEmpty())
		{
			logger.error(properties.getLog().getNoelection()+"by electionname" +electionname+" "+ "and statename"+" "+statename);     //Logger Error 
			 throw new ResultNotFoundException(properties.getLog().getNoresult()+"for"+" " +electionname +" "+"and"+" "+statename);         //ResultNotFoundException
		}
		else
		{
			logger.info(properties.getLog().getFound());				//logger Info
			logger.info(resultEntity.toString());
			return ResultUtil.convertResultEntityListIntoResultList(resultEntity);   //Convert ResultEntity List to Result List
		}
	}
	
	
	@Override
	public List<Result> insertIntoResult(String electionname, String statename) throws ResultNotFoundException //Method to insert the Result of Election in Result Table
	{
		
		List<ResultEntity> resultEntity=resultRepo.getAllResult(electionname, statename);
		if(resultEntity.isEmpty())
		{
			logger.error(properties.getLog().getNoelection()+"by electionname" +electionname+" "+ "and statename"+" "+statename);     //Logger Error 
			 throw new ResultNotFoundException(properties.getLog().getNoresult()+"for"+" " +electionname +" "+"and"+" "+statename);         //ResultNotFoundException
		}
		else
		{
		logger.info(properties.getLog().getSuccess());  //Logger Info
		return ResultUtil.convertResultEntityListIntoResultList(resultRepo.saveAll(resultRepo.getAllResult(electionname, statename))); //Convert ResultEntity List to Result List
		}
	}

	
	
	@Override
	public List<Result> viewResultByStateName(String statename) throws ResultNotFoundException
	{
		List<ResultEntity> resultEntity=resultRepo.findByState(statename);  //Method to view Result Of Election By State Name
		if(resultEntity.isEmpty())
		{
			 logger.error(properties.getLog().getNoresult()+"for state"+" "+statename);						//logger error
			 throw new ResultNotFoundException("NO Result  found for state"+" "+statename);   //ResultNotoundException if result not found by stateName
		}
		else
		{
			logger.info(properties.getLog().getSuccess()+"for state"+" "+statename);						//logger info
			logger.info(resultEntity.toString());
			return ResultUtil.convertResultEntityListIntoResultList(resultEntity); 		//return result based on state Name
		}
	}

	
	@Override
	public List<Result> viewResult()       //Method to return Result of All Elections
	{
		logger.info(properties.getLog().getView() +"Results of Elections");      //logger info
		return ResultUtil.convertResultEntityListIntoResultList(resultRepo.findAll());   //return result of all elections
	}

	
	@Override
	public List<Result> viewResultByPartyName(String partyname) throws ResultNotFoundException  //Method to view Result Of Election By Party Name
	{	
		List<ResultEntity> resultEntity=resultRepo.findByPartyName(partyname);
		if(resultEntity.isEmpty())
		{
			 logger.error(properties.getLog().getNoresult() +"for party"+" "+partyname);			//logger error
			 throw new ResultNotFoundException(properties.getLog().getNoresult()+ "by Party Name"+partyname);		//ResultNotoundException if result not found by PartyName
		}
		else
		{
			 logger.info(properties.getLog().getSuccess()+"for party"+" "+partyname);					//logger info
			logger.info(resultEntity.toString());
			 return ResultUtil.convertResultEntityListIntoResultList(resultEntity);			//return resultList based on partyName
		}
	}

	@Override
	public List<Result> viewResultByElectionName(String electionname) throws ResultNotFoundException //Method to view Result Of Election By Election Name
	{
		
		List<ResultEntity> resultEntity=resultRepo.findByElectionName(electionname);  
		if(resultEntity.isEmpty())
		{
			 logger.error(properties.getLog().getNoresult()+"for election"+" "+electionname);		//	logger.error
			 throw new ResultNotFoundException(properties.getLog().getNoresult()+"by Election Name"+electionname);    //ResultNotoundException if result not found by ElectionName
		}
		else
		{
			logger.info(resultEntity.toString());
			logger.info(properties.getLog().getSuccess() +"for election"+" "+electionname);			//logger.info
			return ResultUtil.convertResultEntityListIntoResultList(resultEntity);   //Return ResultList based on Election Name
		}
	}
	
	@Override
	public List<State> getAllStateName()    //Method to get all State Names
	{
		logger.info(properties.getLog().getView() + "States");       //logger.info
		return  ResultUtil.convertStateEntityListIntoStateList(staterepo.findAll());   //return StateList of all state
	}

	@Override
	public List<Result> deleteByResultId(int result_id) throws ResultNotFoundException    //to delete the result of election by Result id 
	{
		Optional<ResultEntity> opResultEntity = resultRepo.findById(result_id);       
		Result result = null;
		if(opResultEntity.isPresent())
		{
			
			logger.info("Delete Result of an Election by resultId"+" "+result_id);     //logger info
			 resultRepo.deleteById(result_id);
			 List<ResultEntity> resultEntity=resultRepo.findAll();
			 
				logger.info(opResultEntity);
				logger.info(resultEntity);
			 return ResultUtil.convertResultEntityListIntoResultList(resultEntity);
		}
		else
		{
			logger.error(properties.getLog().getNoresult()+ "by ResultId"+" "+result_id);    //logger error
			throw new ResultNotFoundException(properties.getLog().getNoresult()+"for id"+result_id);   //ResultNotoundException if result not found by resultid
		}	
		
	}


	@Override
	public List<String> getResultByState() {
		return resultRepo.findDistinctState(); 
	}


	@Override
	public List<String> getResultByElection() {
		return resultRepo.findDistinctElection(); 
	}


	@Override
	public List<String> getResultByParty() {
		return resultRepo.findDistinctParty(); 
	}


	@Override
	public List<String> getElectionByCast() {
	return resultRepo.getElectionByCast();
	}
	}

