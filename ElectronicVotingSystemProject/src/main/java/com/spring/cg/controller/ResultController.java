
package com.spring.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.ResultNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Result;
import com.spring.cg.json.State;
import com.spring.cg.service.ResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value="Result Related Rest APIs")
public class ResultController {

@Autowired
Myproperties properties;

@Autowired
private ResultService resultService; //ResultService Interface
private static final Logger logger = LogManager.getLogger(ResultController.class); //logger

@ApiOperation(value ="View Vote Counts Of Candidates")  //swagger Documentations
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such Election Found "), //httpStatus Code
			@ApiResponse(code=200,message="Election found Sucessfully "),
			@ApiResponse(code=400,message="Invalid Inputs")	
	})
    //Get METHOD
	@GetMapping(value="/result/{election_name}/{state}", produces=MediaType.APPLICATION_JSON_VALUE) //To count Votes of the Candidate based on electionname and statename
	
	public List<Result> getResult(@PathVariable("election_name") String electionname, @PathVariable("state") String statename) throws ResultNotFoundException
	{
		logger.info("This method will Return Votes of Candidate in"+" "+electionname+ "from"+" "+statename) ; //logger info
		return resultService.getResult(electionname,statename);		
	}



@ApiOperation(value ="Add Vote Counts Of Candidates into Result")  //swagger Documentation

@ApiResponses(value= {
		@ApiResponse(code=201,message="New Result Created "),
		@ApiResponse(code=404,message="No such Election Found "),     //httpStatus Code
		@ApiResponse(code=200,message="Result Added Sucessfully ")
		})	
  //To store Result of the candidate in the Result table based on electionname and stateName
	@PostMapping(value="/result/{election_name}/{state}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)  //POST METHOD
	public List<Result> insertIntoResult(@Valid @PathVariable("election_name") String electionname, @PathVariable("state") String statename) throws ResultNotFoundException
	{
		logger.info(properties.getLog().getOutput()+"Add Votes of Candidate in"+" "+electionname+ "from"+" "+statename+" "+" into Result table") ; //logger info
		return  resultService.insertIntoResult(electionname,statename);
	}
	



@ApiOperation(value ="View Result of Election by State Name ")    //Swagger Documentation

@ApiResponses(value= {
		@ApiResponse(code=404,message="No such Result Found By this State Name"), 
		@ApiResponse(code=400,message="Invalid Input"), //httpStatus Code
		@ApiResponse(code=200,message="Result found Sucessfully ")				
	})
	//Get Method
	@GetMapping(value="/result/statename/{state}", produces=MediaType.APPLICATION_JSON_VALUE) // Method to get the Result Of the Election by State Name
	public List<Result> viewResultByStateName(@PathVariable("state") String statename ) throws ResultNotFoundException
	{
		logger.info(properties.getLog().getOutput()+"Results of election from state"+" "+statename);  //logger info
		return resultService.viewResultByStateName(statename);
	}

	


@ApiOperation(value ="View Result of Election by Party Name ")  //Swagger Documentation

@ApiResponses(value= {
		@ApiResponse(code=404,message="No such Result Found By this Party Name"),
		@ApiResponse(code=400,message="Invalid Input"),  //httpStatus Code
		@ApiResponse(code=200,message="Result found Sucessfully ")		
		}) 
	//GET METHOD
	@GetMapping(value="/result/partyname/{party_name}", produces=MediaType.APPLICATION_JSON_VALUE) //Method to get the Result of the Election by Party Name
	public List<Result> viewResultByPartyName(@PathVariable("party_name") String partyname ) throws ResultNotFoundException
	{   logger.info(properties.getLog().getOutput()+"Results of election from party"+" "+partyname);   //logger Info
		return resultService.viewResultByPartyName(partyname);
	}


@ApiOperation(value ="View Result of Election by Election Name ")  //Swagger Documentation

@ApiResponses(value= {
		@ApiResponse(code=404,message="No such Result Found By this Election Name"),  
		@ApiResponse(code=400,message="Invalid Input"),    //httpStatusCode
		@ApiResponse(code=200,message="Result found Sucessfully ")		
		})
	//GET METHOD
	@GetMapping(value="/result/electionname/{election_name}", produces=MediaType.APPLICATION_JSON_VALUE)// Method to get the Result of the Election By Party Name
	public List<Result> viewResultByElectionName(@PathVariable("election_name") String electionname ) throws ResultNotFoundException
	{
	 	logger.info(properties.getLog().getOutput()+"Results of election by electionNmae"+" "+electionname); //logger Info
		return resultService.viewResultByElectionName(electionname);
	}



@ApiOperation(value ="View ALL Result of Election")  //Swagger Documentation
@ApiResponses(value= {
		@ApiResponse(code=404,message="No  Result Found"),   
		@ApiResponse(code=400,message="Invalid Input"),			//httpStatus Code
		@ApiResponse(code=200,message="Result found Sucessfully ")	
	})
	//GET METHOD
	@GetMapping(value="/result",produces=MediaType.APPLICATION_JSON_VALUE) //Method to get the Result of all Election
	public List<Result> viewAllResult()
	{ logger.info(properties.getLog().getOutput()+"Results of all the elections"); //logger Info
		return resultService.viewResult();
	}



@GetMapping(value="/statewise",produces=MediaType.APPLICATION_JSON_VALUE) //Method to get the Result of all Election
public List<String> viewstatewise()
{ logger.info(properties.getLog().getOutput()+"Results of all the elections"); //logger Info
	return resultService.getResultByState();
}



@GetMapping(value="/electionwise",produces=MediaType.APPLICATION_JSON_VALUE) //Method to get the Result of all Election
public List<String> viewelectionwise()
{ logger.info(properties.getLog().getOutput()+"Results of all the elections"); //logger Info
	return resultService.getResultByElection();
}


@GetMapping(value="/partywise",produces=MediaType.APPLICATION_JSON_VALUE) //Method to get the Result of all Election
public List<String> viewpartywise()
{ logger.info(properties.getLog().getOutput()+"Results of all the elections"); //logger Info
	return resultService.getResultByParty();
}


@GetMapping(value="/castelectionname", produces=MediaType.APPLICATION_JSON_VALUE)
public List<String> viewcastelectionname()
		{
	return resultService.getElectionByCast();
		}




@ApiOperation(value ="View States for Elections ")  //Swagger Documentation

@ApiResponses(value= {	
		@ApiResponse(code=200,message="States found Sucessfully ")	,
		@ApiResponse(code=400,message="Invalid Input")//httpStatus Code
})
	//GET METHOD
	@GetMapping(value="/state",produces=MediaType.APPLICATION_JSON_VALUE) //Method to get all the  State Name
	public List<State> getAllStatesName()
	{
	 	logger.info(properties.getLog().getOutput()+" all the StatesName"); //logger Info
	 	return resultService.getAllStateName();
	}



    
    

@ApiOperation(value ="Returns true/false for delete")   //Swagger Documentation

@ApiResponses(value= {
		@ApiResponse(code=201,message="Deleted"),	
		@ApiResponse(code=400,message="Invalid Input"),    //httpStatus Code
		@ApiResponse(code=404,message="No such election found")		
		})
@Transactional
	//DELETE METHOD
	@DeleteMapping(value="/result/{result_id}",produces=MediaType.APPLICATION_JSON_VALUE)   //Method to delete the Result by Result Id
		public List<Result> deleteResultById( @PathVariable int result_id) throws ResultNotFoundException
		{
			logger.info(properties.getLog().getOutput()+"deletes the result of the election by result Id"); //logger Info
			return resultService.deleteByResultId(result_id); 
		}
}

