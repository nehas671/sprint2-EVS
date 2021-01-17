package com.spring.cg.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.Myproperties;
import com.spring.cg.entity.VoterIdEntity;

import com.spring.cg.json.VoterId;

import com.spring.cg.service.VoterIdService;
import com.spring.cg.service.VoterIdServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value = "Voter Related REST api")
public class VoterIdController {
	private static final Logger logger = LogManager.getLogger(VoterIdServiceImpl.class);
	@Autowired
	private VoterIdService voterIdService;

	@Autowired
	Myproperties properties;

	@ApiOperation(value = "returns voter id for a user id given")

	@ApiResponses(value = {

			@ApiResponse(code = 404, message = "User does not exists") })
	/*
	 * To get the voter id by applicaton id
	 */
	@GetMapping(value = "/user/voterId/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public VoterId getByUserId(@PathVariable Long user_id) throws UserNotFoundException {
		logger.info(properties.getLog().getFound());
		return voterIdService.getByApplicationId(user_id);
	}

	@ApiOperation(value = "returns all voter requests")
	@ApiResponses(value = {

			@ApiResponse(code = 404, message = "Voter request not found") })
	/*
	 * To get all the voter requests
	 */
	@GetMapping(value = "/admin/voterRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VoterIdEntity> viewAllRequests() throws UserNotFoundException {
		logger.info(properties.getLog().getView() + " Voter requests ");
		return voterIdService.getAllRequests();
	}

	@ApiOperation(value = "returns all voter requests of the district given")
	@ApiResponses(value = {
			/*
			 * To get the voter request by district
			 */
			@ApiResponse(code = 404, message = "Voter request not found") })
	@GetMapping(value = "/admin/voterRequest/{district}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VoterId> viewByDistrict(@PathVariable String district) throws UserNotFoundException {
		logger.info(properties.getLog().getFound());
		return voterIdService.getByDistrict(district);
	}

	@ApiOperation(value = "returns all voter requests of the  status given")
	@ApiResponses(value = {

			@ApiResponse(code = 404, message = "Voter request not found") })
	/*
	 * To get the voter request by status
	 */
	@GetMapping(value = "/admin/voterRequestbystatus/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VoterIdEntity> viewByStatus(@PathVariable String status) throws UserNotFoundException {
		logger.info(properties.getLog().getFound());
		return voterIdService.getByStatus(status);
	}
	
	@GetMapping(value="/voterRequest/districts",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> viewAllDistricts(){
		return voterIdService.getAllDistricts();
		
	}
	@GetMapping(value="/voterRequest/status",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> viewAllStatus(){
		return voterIdService.getAllStatus();
		
	}
	@GetMapping(value="/user/voterIdbyemail/{emailId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public VoterIdEntity viewByEmailId( @PathVariable String emailId)throws UserNotFoundException{
		return voterIdService.getByEamilId(emailId);
	
}
}
