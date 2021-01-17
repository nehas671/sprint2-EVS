package com.spring.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.exception.PartyNotFoundException;
import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;
import com.spring.cg.service.PartyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value="Election related Rest APIs")
public class PartyController {
	
	
	private static final Logger logger = LogManager.getLogger(PartyController.class);

	
	@Autowired
	Myproperties properties;
	
	@Autowired
	private PartyService partyService;

	
	
	
	/********************To create party*********************/
	
	
	@ApiOperation(value ="create new  Party")
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="New Party created"),
			@ApiResponse(code=404,message="No such Party created")
			
	})
	@PostMapping(value="/election/party",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Partys> addNewParty(@Valid @RequestBody Partys party)
	{
		return new ResponseEntity<Partys>(partyService.createParty(party), HttpStatus.OK);
		
	}
	

	
	
	
	/*****************To display party list*****************/
	
	
    @ApiOperation(value ="Returns all parties")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such parties found")
			
	})
	@GetMapping(value="/election/party",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Partys> getAllParties(){
		
		return partyService.getAllParties() ;
	}
    
    
    
    
    
    /********************To display party by party Name*******************/
    
    
    
    @ApiOperation(value ="Returns Party By Party Name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such party found")
			
	})
	@GetMapping(value="election/party/partyName/{party_name}",produces=MediaType.APPLICATION_JSON_VALUE)				 
    public Partys getPartyByPartyName(@PathVariable String party_name) throws PartyNotFoundException {			
		logger.info(properties.getLog().getView()+" Party By party name "+party_name);					//logger info
		return partyService.getPartyByPartyName(party_name) ;
	}
	
    
    
    
    
    
    /*******************To return party Name **********************/
    
    
    @ApiOperation(value ="Returns Party Name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No party Name found")
			
	})
	@GetMapping(value="party/partyName",produces=MediaType.APPLICATION_JSON_VALUE)				 
    public List<String> getPartyName() throws PartyNotFoundException {			
		logger.info("get all parties Name");					//logger info
		return partyService.getPartyName() ;
	}
	

    
    
    /*******************To return leader Name **************************/
    
    
    
    @ApiOperation(value ="Returns Leader Name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No Leader found")
			
	})
	@GetMapping(value="party/leader",produces=MediaType.APPLICATION_JSON_VALUE)				 
    public List<String> getLeaderName() throws PartyNotFoundException {			
		logger.info("get all leader");					//logger info
		return partyService.getLeaderName() ;
	}

    
    
    
    /******************To retrun symbols*****************/
    
    
    @ApiOperation(value ="Returns Symbols")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No symbol found")
			
	})
	@GetMapping(value="party/symbol",produces=MediaType.APPLICATION_JSON_VALUE)				 
    public List<String> getSymbol() throws PartyNotFoundException {			
		logger.info("get all Symbols");					//logger info
		return partyService.getSymbol() ;
	}

    
    
    
    /******************To return party by party name**********************/
    
    
    
   @ApiOperation(value ="Returns Party By Leader Name")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such party found")
			
	})
	@GetMapping(value="election/party/leader/{leader}",produces=MediaType.APPLICATION_JSON_VALUE)				 
    public List<Partys>  getAllPartyByLeaderName(@PathVariable String leader) throws PartyNotFoundException {			
		logger.info(properties.getLog().getView()+" Party By party leader "+leader);					//logger info
		return partyService.getAllPartyByLeaderName(leader) ;
	}

   
   
   
   
   /*********************To retrun party by symbol*********************/
   
   
    
    @ApiOperation(value ="Returns Party By symbol")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such party found")
			
	})
	@GetMapping(value="election/party/symbol/{symbol}",produces=MediaType.APPLICATION_JSON_VALUE)				 
    public List<Partys> getAllPartyBySymbol(@PathVariable String symbol) throws PartyNotFoundException {			
		logger.info(properties.getLog().getView()+" Party By party leader "+symbol);					//logger info
		return partyService.getAllPartyBySymbol(symbol) ;
	}
	
    
    
    
    
    /***********************To update election details **********************/
    
    
   @ApiOperation(value ="Updates elections details")
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="New Election created"),
			@ApiResponse(code=404,message="No such election found")
			
	})
	@PutMapping(value="/election/party/",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Election> UpdateElection( @Valid @RequestBody Partys party) throws Exception{
		
		
	return  partyService.UpdateElection(party);
		
	}

	
	
	
}
