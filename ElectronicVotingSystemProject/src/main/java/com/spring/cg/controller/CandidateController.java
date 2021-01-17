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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cg.Myproperties;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.RecordNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Party;
import com.spring.cg.service.CandidateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value="Candidate related Rest APIs")
public class CandidateController {
	
	private static final Logger logger = LogManager.getLogger(CandidateController.class);
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	Myproperties properties;
	
	
	
	/*
     * --------------------------------------------------------- POST MAPPING TO ADD NEW CANDIDATE --------------------------------------------------------------------------
     **/
	
      @ApiOperation(value ="create new candidate")
	
	        @ApiResponses(value= {
			@ApiResponse(code=201,message="New candidate created"),
			@ApiResponse(code=404,message="No such candidate created"),
			@ApiResponse(code=400,message="Invalid Candidate Inputs"),
			@ApiResponse(code=200,message="Status OK")
			
	})
      
	@PostMapping(value="/candidate", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Candidate> createNewCandidate(@Valid @RequestBody Candidate candidate) {
    	  logger.info("Creating Candidate :" +candidate);
		return new ResponseEntity<Candidate>(candidateService.createCandidate(candidate), HttpStatus.OK);
	}
      
      
      
      /*
       * ----------------------------------------------------- GET MAPPING TO VIEW LIST OF ALL CANDIDATES -------------------------------------------------------------------
       **/
      
        @ApiOperation(value ="returns all candidate")
  	
        @ApiResponses(value= {
		@ApiResponse(code=201,message="All candidates returned successfully"),
		
    })
	@GetMapping(value="/candidate", produces=MediaType.APPLICATION_JSON_VALUE)  
	public List<Candidate> getAllCandidates() throws RecordNotFoundException{
        	logger.info(properties.getLog().getView() + " Candidates");
		return candidateService.getAllCandidates();
	}
        
	
        
        /*
         * ------------------------------------------------------- GET MAPPING TO VIEW LIST OF ALL CANDIDATES BY THEIR NAME ------------------------------------------------- 
         **/
        
        @ApiOperation(value ="returns candidate by candidate_name")
  	
        @ApiResponses(value= {
		@ApiResponse(code=201,message="Candidates by name returned successfully"),
		@ApiResponse(code=404,message="No such candidate found")
		
    })
	@GetMapping(value="/candidate/{candidate_name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getCandidateByCandidateName(@PathVariable("candidate_name") String candidate_name) 
			throws CandidateNotFoundException{
        	logger.info(properties.getLog().getView() + " candidates by their name");
		return candidateService.getCandidateByCandidateName(candidate_name);
	}
        
	
        
        /*
         * ---------------------------------------------------- GET MAPPING TO VIEW LIST OF ALL CANDIDATE BY THEIR PARTY NAME ----------------------------------------------
         **/
        
        @ApiOperation(value ="returns candidate by party_name")
    	
        @ApiResponses(value= {
		@ApiResponse(code=201,message="Candidate by party name returned"),
		@ApiResponse(code=404,message="No such candidate found")
		
    })
	@GetMapping(value="/candidate/party/{party_name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getCandidateByPartyName(@PathVariable("party_name") String party_name) 
			throws CandidateNotFoundException{
        	logger.info(properties.getLog().getView() + " candidates by their party name");
		return candidateService.getCandidateByPartyName(party_name);
	}
        
        
        
        /*
         * ------------------------------------------------------------GET MAPPING TO VIEW LIST OF CANDIDATES BY THEIR EMAIL -----------------------------------------------
         */
        
        
 @ApiOperation(value ="returns candidate by email")
    	
        @ApiResponses(value= {
		@ApiResponse(code=201,message="Candidate by email returned"),
		@ApiResponse(code=404,message="No such candidate found")
		
    })
        @GetMapping(value="/candidate/email/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
    	public List<Candidate> getCandidateByEmail(@PathVariable("email") String email) 
    			throws CandidateNotFoundException{
            	logger.info(properties.getLog().getView() + " candidates by their email");
    		return candidateService.getCandidateByEmail(email);
    	}
        
        
        /*
         * ----------------------------------------------------------------GET MAPPING TO VIEW LIST OF CANDIDATES BY THEIR CONTACT NUMBER-------------------------------------
         */
        
 
             @ApiOperation(value ="returns candidate by contact_number")
	
            @ApiResponses(value= {
	        @ApiResponse(code=201,message="Candidate by contact number returned"),
	        @ApiResponse(code=404,message="No such candidate found")
	
            })
        @GetMapping(value="/candidate/number/{contact_number}", produces=MediaType.APPLICATION_JSON_VALUE)
    	public List<Candidate> getCandidateByNumber(@PathVariable("contact_number") String contact_number) 
    			throws CandidateNotFoundException{
            	logger.info(properties.getLog().getView() + " candidates by their number");
    		return candidateService.getCandidateByNumber(contact_number);
    	}
        
        /*
         * ------------------------------------------------------------------GET MAPPING TO VIEW ALL PARTY--------------------------------------------------------------------
         */
             
             @ApiOperation(value ="returns all party")
         	
             @ApiResponses(value= {
     		@ApiResponse(code=201,message="Party is returned"),
     		
         })
        @GetMapping(value="/party", produces=MediaType.APPLICATION_JSON_VALUE)
    	public List<Party> getAllPartys() {
    		return candidateService.getAllPartys();
    	}
        
        
        /*
         * -------------------------------------------------------------------GET MAPPING TO VIEW ALL CANDIDATE NAME-------------------------------------------------------
         */
             
             @ApiOperation(value ="returns distinct candidate name")
         	
             @ApiResponses(value= {
     		@ApiResponse(code=201,message="Distinct candidate name is returned"),
     		
         })
        @GetMapping(value="/candidatename", produces= MediaType.APPLICATION_JSON_VALUE)
        public List<String> getCandidateName(){
        	return candidateService.getCandidateName();
        }
        
        /*
         * --------------------------------------------------------------------GET MAPPING TO VIEW ALL PARTY NAME----------------------------------------------------------
         */
             
             @ApiOperation(value ="returns distinct party_name")
         	
             @ApiResponses(value= {
     		@ApiResponse(code=201,message="Distinct Party name is returned"),
     		
         })
        
        @GetMapping(value="/partyname", produces= MediaType.APPLICATION_JSON_VALUE)
        public List<String> getPartyName(){
        	return candidateService.getPartyName();
        }
        
        /*
         * -----------------------------------------------------------------------GET MAPPING TO VIEW ALL CANDIDATE EMAILS--------------------------------------------------
         */
             @ApiOperation(value ="returns candidate email")
         	
             @ApiResponses(value= {
     		@ApiResponse(code=201,message="Candidate email is returned"),
     		
         })
        @GetMapping(value="/email", produces= MediaType.APPLICATION_JSON_VALUE)
        public List<String> getEmail(){
        	return candidateService.getEmail();
        }
        
             
             /*
              * ------------------------------------------------GET MAPPING TO VIEW ALL CANDIDATE CONTACT NUMBER----------------------------------------------------------
              */
             
             @ApiOperation(value ="returns candidate contact_number")
         	
             @ApiResponses(value= {
     		@ApiResponse(code=201,message="Candidate contact number is returned")
     		
         })
        @GetMapping(value="/number", produces= MediaType.APPLICATION_JSON_VALUE)
        public List<String> getNumber(){
        	return candidateService.getNumber();
        }
	
        
        /*
         * ---------------------------------------------------------- DELETE MAPPING TO DELETE ALL CANDIDATES BY THEIR NAME -------------------------------------------------
         **/
        
        @ApiOperation(value ="delete candidate by candidate_name")
    	
        @ApiResponses(value= {
		@ApiResponse(code=201,message="Candidate by candidate_name deleted"),
		@ApiResponse(code=404,message="No such candidate found")
		
    })
	@DeleteMapping(value= "/candidate/{candidate_name}/delete/", produces = MediaType.APPLICATION_JSON_VALUE)  
	private List<Candidate> deleteCandidateByCandidateName(@PathVariable("candidate_name") String candidate_name)   
			throws CandidateNotFoundException{  
        	logger.info(properties.getLog().getDelete() + " candidates by their name");
	      return candidateService.deleteCandidate(candidate_name);  
	}
        
        
        
        /*
         *------------------------------------------------------------ DELETE MAPPING TO DELETE A CANDIDATE BY HIS ID -------------------------------------------------------
         **/
        
        @ApiOperation(value="delete candidate by candidate_id")
    	@ApiResponses(value= {
    			@ApiResponse(code=201,message="candidate by candidate_id deleted"),
    			@ApiResponse(code=404,message="No candidate exists")
    	})
    	 @DeleteMapping(value = "/candidate/delete/{candidate_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    	public Candidate deleteById(@PathVariable(value="candidate_id") Integer candidate_id) 
    			throws CandidateNotFoundException{
    			logger.info(properties.getLog().getDelete() + " candidate by their Id");
    			return candidateService.deleteById(candidate_id);
    	 }
}

