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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.service.UpdateAndDeleteCandidateService;

import io.swagger.annotations.*;




@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value="Update and Delete candidate related Rest APIs")




/*------------------------------------- Update And Delete Controller------------------------------------------------*/
public class UpdateAndDeleteCandidateController {

	private static final Logger logger = LogManager.getLogger(UpdateAndDeleteCandidateController.class);
	
	@Autowired
	private UpdateAndDeleteCandidateService updateAndDeleteCandidateService;
	
	
	
	@Autowired
	Myproperties properties;
	
	
	
	
	
	@ApiOperation(value ="Return details of candidate by Email Id")						//Return candidate details 
	
	@ApiResponses(value= {
			@ApiResponse(code=404,message="No candidate found by email Id")
			
	})
	
	
	
	
	/**-------------Mapping to get Candidate details for entered Email Id--------------**/
	
	
	
	@GetMapping(value="updateAndDeleteCandidate/email/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Candidate getCandidateByEmail(@PathVariable String email) throws CandidateNotFoundException{
	
			logger.info("All Candidates");
			logger.warn("warning logger");
			logger.error("error logger");
			logger.debug("debug logger");
			return updateAndDeleteCandidateService.getCandidateByEmail(email) ;
	}
	
	

	
	
	/*
	
	@ApiOperation(value ="Update candidate name by using email Id")							//Return updated Name
	
		@ApiResponses(value= {
				@ApiResponse(code=201,message="Candidate details updated"),
				@ApiResponse(code=404,message="No candidate found by email Id")
			
		})
	
	
	
	/**----------------Mapping for updating candidate Name by using Email Id---------------------
	
	
	@PutMapping(value="/updateCandidate/name/{email}/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	
		public Candidate UpdateCandidateName(@PathVariable String email , String name) throws CandidateNotFoundException
		{
		
			logger.info(properties.getLog().getForUpdating()+" name "+name);
			return  updateAndDeleteCandidateService.updateCandidateName(email, name);
		
		}
	
	
	
	
	
	
	
	
	@ApiOperation(value ="Update candidate address by using email Id")						//Return updated Address
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Candidate details updated"),
			@ApiResponse(code=404,message="No candidate found by email Id")
		
	})
	
	
	/**----------------Mapping for updating candidate Address by using Email Id---------------------
	
	
	
	@PutMapping(value="/updateAddress/address/{email}/{address}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Candidate UpdateAddress(@PathVariable String email , String address) throws CandidateNotFoundException
		{
	
			logger.info(properties.getLog().getForUpdating()+" Address "+address);
			return  updateAndDeleteCandidateService.updateAddress(email, address);
	
		}
	
	
	
	
	
	
	
	@ApiOperation(value ="Update candidate age by using email Id")								//Return updated Age
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="Candidate details updated"),
			@ApiResponse(code=404,message="No candidate found by email Id")
		
	})
	
	
	
	/**----------------Mapping for updating candidate Age by using Email Id---------------------
	
	
	
	@PutMapping(value="/updateAge/age/{email}/{age}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Candidate UpdateAge(@PathVariable String email , int age) throws CandidateNotFoundException, InvalidAgeException
		{
	
			logger.info(properties.getLog().getForUpdating()+" Age "+age);
			return  updateAndDeleteCandidateService.updateAge(email, age);
	
		}
	
	

	
	
	
	
	@ApiOperation(value ="Updated contact number for Candidate Entity")                   //Return updated candidate number 
	
		@ApiResponses(value= {
				@ApiResponse(code=201,message="Candidate details updated"),
				@ApiResponse(code=404,message="No candidate found by email Id")
			
		})
	
	
	
	/*******-------------Mapping for updating candidate Address by using Email Id------------------
	
	
	@PutMapping(value="/updateCandidate/contact/{email}/{contact_number}",produces=MediaType.APPLICATION_JSON_VALUE)
		public Candidate UpdateContactNumber(@PathVariable String email , String contact_number) throws CandidateNotFoundException
		{
		
			logger.info(properties.getLog().getForUpdating()+" Contact Number "+contact_number);
			return  updateAndDeleteCandidateService.updateContactNumber(email, contact_number);
		
		}
	
	
	
	*/
	
	
@ApiOperation(value ="Updates candidate details")
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="New Candidate created"),
			@ApiResponse(code=404,message="No such candidate found")
			
	})
	@PutMapping(value="/updatecandidate/{CandidateId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Candidate updateCandidate(@PathVariable Integer CandidateId, @Valid @RequestBody Candidate candidate) throws CandidateNotFoundException{
		
		
		return  updateAndDeleteCandidateService.updateCandidate(CandidateId,candidate);
		
	}
	

	
	
	
	
	
	@ApiOperation(value ="Returns true/false for delete")                          //Return true after delete else false
	
		@ApiResponses(value= {
				@ApiResponse(code=201,message="Deleted"),
				@ApiResponse(code=404,message="No such candidate found")
			
		})
	
	
	/**----------------------Mapping for delete by using Email Id------------------------**/
	
	
	
	@Transactional
	@DeleteMapping(value="/deleteCandidate/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Candidate> deleteById( @PathVariable Integer id) throws CandidateNotFoundException
	{
		
		logger.info(properties.getLog().getDelete());
		return updateAndDeleteCandidateService.deleteById(id);
	
		
	}
	
	
}
