package com.spring.cg.utils;

import java.util.ArrayList;

import java.util.List;

import com.spring.cg.entity.ResultEntity;
import com.spring.cg.entity.StateEntity;
import com.spring.cg.json.Result;
import com.spring.cg.json.State;


	
	public class ResultUtil 
	{	
		public static ResultEntity convertResultIntoResultEntity(Result result)  //Method to convert result class into resultEntity class
			{
					return new ResultEntity( result.getResult_id(), result.getElection_name(),result.getState(), result.getDate(),result.getConstituency(),result.getCandidate_name(),result.getParty_name(),result.getVotes());
			}
			
		public static Result convertResultEntityIntoResult(ResultEntity resultEntity) //Method to convert resultEntity class into result class
			{
					return new Result(resultEntity.getResult_id(),resultEntity.getElection_name(),resultEntity.getState(),resultEntity.getDate(),resultEntity.getConstituency(),resultEntity.getCandidate_name(),resultEntity.getParty_name(),resultEntity.getVotes());
			}



		public static List<Result> convertResultEntityListIntoResultList(List<ResultEntity> resultEntityList)
		 //method to convert ResultEntityList into ResultList
		{
			List<Result> result = new ArrayList<Result>();
			for(ResultEntity resultEntity: resultEntityList) {
				result.add(convertResultEntityIntoResult(resultEntity));
			}
			return result;
		}
		
		 //method to convert StateEntityList into StateList
		public static List<State> convertStateEntityListIntoStateList(List<StateEntity> stateEntityList)
		{
			List<State> states = new ArrayList<State>();
			for(StateEntity stateEntity: stateEntityList) {
				states.add(convertStateEntityIntoState(stateEntity));
			}
			return states;
		}
		
		 //method to convert StateEntity into State
		public static State convertStateEntityIntoState(StateEntity stateEntity) {
			return new State( stateEntity.getState());
		
	}

	
	}
