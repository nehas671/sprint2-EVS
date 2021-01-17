package com.spring.cg.controller;

import java.util.List;

import javax.validation.Valid;

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
	
	
	
	@Autowired
	private PartyService partyService;

	
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
	

	
    @ApiOperation(value ="Returns all parties")
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No such parties found")
			
	})
	@GetMapping(value="/election/party",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Partys> getAllParties(){
		
		return partyService.getAllParties() ;
	}
	
	
    
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
