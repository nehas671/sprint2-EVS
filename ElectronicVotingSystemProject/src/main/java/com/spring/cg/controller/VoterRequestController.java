package com.spring.cg.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.exception.RequestNotApproved;
import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.json.VoterRequest;
import com.spring.cg.service.VoterRequestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/evs")
@Api(value="VoterRequest related Rest APIs")
@CrossOrigin("*")
public class VoterRequestController {
	
	@Autowired
	private VoterRequestService voterRequestService;

	
	@ApiOperation(value="Add Voter Request")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Voter Request Added"),@ApiResponse(code=404, message="Not Found")
	})
	@PostMapping(value="/user/voter_request",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoterRequest> addVoterRequest(@Valid @RequestBody VoterRequest voterRequest)throws UserNotFoundException {
		return new ResponseEntity<VoterRequest>(voterRequestService.addVoterRequest(voterRequest) , HttpStatus.ACCEPTED);
	}
	
	

	@ApiOperation(value="Approve or Reject Voter Requests")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Voter Request Approved or rejected")
	})
	@PutMapping(value="/voter_request",produces=MediaType.APPLICATION_JSON_VALUE)
	public VoterRequest approveRejectVoterRequest( @Valid @RequestBody VoterRequest  voterRequest) throws RequestNotApproved{
		
		return voterRequestService.approveVoterRequest(voterRequest);
	}
	
	@ApiOperation(value="Approve or Reject Voter Requests")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Voter Request Approved or rejected")
	})
	@PutMapping(value="/voter_request/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public VoterRequest approveRejectVoterRequestt( @PathVariable Integer id) throws RequestNotApproved{
		
		return voterRequestService.approveVoterRequestt(id);
	}
	
}
