package com.spring.cg.service;

import java.util.List;


import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.json.Result;
import com.spring.cg.json.State;

public interface ResultService {
	//Method to count Votes of an Election based on ElectionName And StateName
	public List<Result> getResult(String electionname, String statename) throws ResultNotFoundException;
	
	//Method to insert the Result of Election in Result Table
	public List<Result>insertIntoResult(String electionname, String statename) throws ResultNotFoundException;
	
	//Method to view Result Of Election By State Name
	public List<Result> viewResultByStateName(String statename) throws ResultNotFoundException;
	
	//Method to return Result of All Elections
	public List<Result> viewResult();
	
	//Method to view Result Of Election By Party Name
	public List<Result> viewResultByPartyName(String partyname) throws ResultNotFoundException;
	
	//Method to view Result Of Election By Election Name
	public List<Result> viewResultByElectionName(String electionname) throws ResultNotFoundException;
	
	//Method to get all State Names
	public List<State> getAllStateName();
	
	//Method to Delete Result Of Election By Result ID
	public List<Result> deleteByResultId(int result_id) throws ResultNotFoundException;

	public List<String> getResultByState();

	public List<String> getResultByElection();

	public List<String> getResultByParty();

	public List<String> getElectionByCast();
}

