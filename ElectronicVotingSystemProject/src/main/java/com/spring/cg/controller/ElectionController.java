package com.spring.cg.controller;


import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.cg.Myproperties;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.exception.InvalidStateException;
import com.spring.cg.json.Election;
import com.spring.cg.json.State;
import com.spring.cg.service.ElectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value="Election related Rest APIs")
public class ElectionController {
	
	private static final Logger logger = LogManager.getLogger(ElectionController.class);
	
	
	@Autowired
	private ElectionService electionService;
	
	@Autowired
	Myproperties properties;
	
	@ApiOperation(value ="creates New  elections")
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="New election created"),
			@ApiResponse(code=404,message="No such election created"),
			@ApiResponse(code=400,message="Invalid Election Inputs")
			
			
	})
	@PostMapping(value="/election",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)   //Method for Creating new Election
	public ResponseEntity<Election> addNewElection(@Valid @RequestBody Election election) throws InvalidStateException
	{
		
		return new ResponseEntity<Election>(electionService.createElection(election), HttpStatus.OK);
		
	}
	
	
	@ApiOperation(value ="Returns All Elections")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such election found")
			
	})
	@GetMapping(value="/election",produces=MediaType.APPLICATION_JSON_VALUE)   //Method To GET (Viewing) all Elections 
	public List<Election> getAllElection() throws ElectionNotFoundException{	
		
		
		logger.info(properties.getLog().getView()+" Elections");				//logger info
		return electionService.getAllElection() ;							//returns All Elections
	}
	
	
	
	@ApiOperation(value ="Returns All States")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No state found")
			
	})
	@GetMapping(value="/states",produces=MediaType.APPLICATION_JSON_VALUE)	    				//Method To get ALL States				
	public List<State> getAllStates(){
		
		
		return electionService.getAllStates() ;
	}
	


	@ApiOperation(value ="Returns All Elections By State")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such election found")
			
	})
	@GetMapping(value="election/state/{state}",produces=MediaType.APPLICATION_JSON_VALUE)				 
	public List<Election> getAllElectionByState(@PathVariable String state) throws ElectionNotFoundException{		//Method To View ALL Election By State
		
		logger.info(properties.getLog().getView()+" Election By State "+state);					//logger info
		return electionService.getAllElectionByState(state) ;
	}
	
	
	
	@ApiOperation(value ="Returns All Elections By Election Name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No election found")
			
	})
	@GetMapping(value="election/electionname/{electionName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Election> getAllElectionByElectionName(@PathVariable String electionName) throws ElectionNotFoundException{		//Method To View ALL Election By Election Name
		
		logger.info(properties.getLog().getView()+" Election By Election Name "+electionName);			//logger Info
		return electionService.getAllElectionByElectionName(electionName) ;
	}
	
	
	
	@ApiOperation(value ="Returns All Elections By Constituency")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such election found")
			
	})
	@GetMapping(value="election/constituency/{constituency}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Election> getAllElectionByConstituency(@PathVariable String constituency) throws ElectionNotFoundException{		//Method To View ALL Election By Constituency
		
		logger.info(properties.getLog().getView()+" Election By Constituency "+constituency); //logger Info
		return electionService.getAllElectionByConstituency(constituency) ;
	}
	
	
	
	@ApiOperation(value ="Returns All Elections By Date")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No election found")
			
	})									
	@GetMapping(value="election/date/{date}",produces=MediaType.APPLICATION_JSON_VALUE)								//Method To View ALL Election By Date
	public List<Election> getAllElectionByDate(@DateTimeFormat(pattern ="yyyy-MM-dd") @PathVariable LocalDate date) throws ElectionNotFoundException{
		
		logger.info(properties.getLog().getView()+" Election By Date "+date);			//logger Info
		return electionService.getAllElectionByDate(date) ;
	}
	
	
	
	
  @ApiOperation(value ="Returns All election name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No election found")
			
	})
	@GetMapping(value="election/electionname",produces=MediaType.APPLICATION_JSON_VALUE)	    				//Method To get ALL States				
	public List<String> getAllElectionName(){
		
		
		return electionService.getAllElectionName() ;
	}
	
  
  
  
  @ApiOperation(value ="Returns All election state name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No election on  state found")
			
	})
	@GetMapping(value="election/statename",produces=MediaType.APPLICATION_JSON_VALUE)	    				//Method To get ALL States				
	public List<String> getAllElectionState(){
		
		
		return electionService.getAllElectionState() ;
	}
  
  
  @ApiOperation(value ="Returns All election constituency name")
	
 	@ApiResponses(value= {
 			@ApiResponse(code=404,message="No election on  constituency found")
 			
 	})
 	@GetMapping(value="election/constituencyname",produces=MediaType.APPLICATION_JSON_VALUE)	    				//Method To get ALL States				
 	public List<String> getAllConstituency(){
 		
 		
 		return electionService.getAllConstituency() ;
 	}
  
  
  @ApiOperation(value ="Returns All election date")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No election on date found")
			
	})
	@GetMapping(value="election/date",produces=MediaType.APPLICATION_JSON_VALUE)	    				//Method To get ALL States				
	public List<LocalDate> getAllDate(){
		
		
		return electionService.getAllDate() ;
	}
	
	
	

	@ApiOperation(value ="Returns true/false for Delete")
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Deleted"),
			@ApiResponse(code=404,message="No Election found")
			
	})
	@Transactional
	@DeleteMapping(value="/election/{electionId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteElectionById( @PathVariable Long electionId) throws ElectionNotFoundException{		//Method To Delete Election By Id
		
		logger.info("Deleting Election By Id:"+electionId);		//logger Info
		return electionService.deleteByElectionId(electionId);
	
		
	}
	
	
	
  
	

}
