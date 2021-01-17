package com.spring.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.Myproperties;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.entity.PartyEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.exception.RecordNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.json.Party;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.PartysRepo;
import com.spring.cg.utils.CandidateUtil;


@Service
public class CandidateServiceImpl implements CandidateService {
	private static final Logger logger = LogManager.getLogger(CandidateServiceImpl.class);
	
	@Autowired
	private CandidateRepo candidateRepo;
	@Autowired
	private PartysRepo partyRepo;
	@Autowired
	Myproperties properties;

	
	
	/*
	 * -----------------------------------------------  METHOD TO CREATE NEW CANDIDATE --------------------------------------------------------------------------------------
	 **/
	@Override
	public Candidate createCandidate(Candidate candidate) {
		Optional<PartyEntity> partyOptional = partyRepo.findByPartyName(candidate.getParty().getPartyName());
		if(partyOptional.isPresent()) {
			PartyEntity partyEntity = partyOptional.get();
			CandidateEntity candidateEntity = 
			candidateRepo.save(CandidateUtil.convertCandidateIntoCandidateEntity(candidate, partyEntity));
			
			logger.info("Candidate added successfully:\n" + candidateEntity);
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);
		}
		return null;
		}

	
	
	/*
	 *  ----------------------------------------------------- METHOD TO GET LIST OF ALL CANDIDATES ---------------------------------------------------------------------------- 
     **/
	
	@Override
	public List<Candidate> getAllCandidates() throws RecordNotFoundException{
		List<CandidateEntity> candidateEntityList = candidateRepo.findAll();
		if(!candidateEntityList.isEmpty()) {
			List<Candidate> candidates = new ArrayList<Candidate>();
		    for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity));
		   }
		    
		    logger.info("List of candidates:\n" + candidates);

		    return candidates;
		}
		else {
			logger.error("No candidate Found");
			throw new RecordNotFoundException("Candidate not found");
		}
		
	}

	
	
	/*
	 *  --------------------------------------------------------- METHOD TO GET LIST OF ALL CANDIDATES BY THEIR NAME --------------------------------------------------------
     **/
	
	public List<Candidate> getCandidateByCandidateName(String candidate_name) throws CandidateNotFoundException {
		List<CandidateEntity> candidateEntityList = candidateRepo.findByCandidateName(candidate_name);
		if(!candidateEntityList.isEmpty()){
			List<Candidate> candidates = new ArrayList<Candidate>();
		    for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity));
		}
		    logger.info("Candidate by name "+ candidate_name + " is:\n" + candidates);
		    return candidates;
		}
		else{
			logger.error("Candidate by name" + candidate_name + " is " + properties.getLog().getNotFound());
			throw new CandidateNotFoundException("Candidate_Name: " + candidate_name);
		}
	}
	
	/*
	 * -------------------------------------METHOD TO GET CANDIDATE BY EMAIL -------------------------------------------------
	 */
	
	public List<Candidate> getCandidateByEmail(String email) throws CandidateNotFoundException {
	    List<CandidateEntity> candidateEntityList = candidateRepo.findByEmail(email);
		if(!candidateEntityList.isEmpty()){
			List<Candidate> candidates = new ArrayList<Candidate>();
		    for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity));
		}
		    logger.info("Candidate by email "+ email + " is:\n" + candidates);
		    return candidates;
		}
		else{
			logger.error("Candidate by email" + email + " is " + properties.getLog().getNotFound());
			throw new CandidateNotFoundException("Candidate_Name: " + email);
		}
	}
	
	/*
	 * ---------------------------------METHOD TO GET CANDIDATE BY NUMBER -------------------------------------------
	 */
	
	public List<Candidate> getCandidateByNumber(String contact_number) throws CandidateNotFoundException {
	    List<CandidateEntity> candidateEntityList = candidateRepo.findByContactNumber(contact_number);
		if(!candidateEntityList.isEmpty()){
			List<Candidate> candidates = new ArrayList<Candidate>();
		    for(CandidateEntity candidateEntity: candidateEntityList) {
			candidates.add(CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity));
		}
		    logger.info("Candidate by number "+ contact_number + " is:\n" + candidates);
		    return candidates;
		}
		else{
			logger.error("Candidate by number" + contact_number + " is " + properties.getLog().getNotFound());
			throw new CandidateNotFoundException("Candidate_Name: " + contact_number);
		}
	}
	
	/*
	 *  -------------------------------------------------------- METHOD TO GET LIST OF ALL CANDIDATES BY THEIR PARTY NAME ---------------------------------------------------
     **/
	
	public List<Candidate> getCandidateByPartyName(String party_name) throws CandidateNotFoundException{
		List<CandidateEntity> candidateEntityList = candidateRepo.findAll();
		   List<Candidate> candidates = new ArrayList<Candidate>();
		       for(CandidateEntity candidateEntity: candidateEntityList) {
			   if(party_name.equals(candidateEntity.getParty().getPartyName()))
			   candidates.add(CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity));
		}
		       if(!candidates.isEmpty()) {
		    	   
		    	   logger.info("Candidate by party_name " + party_name + " is:\n" + candidates);
		    	   
		    	   return candidates;
		       }
		       else {
		    	   
		    	   logger.error("Candidate by party_name " + party_name + " is " + properties.getLog().getNotFound());
		    	   throw new CandidateNotFoundException("Party_Name: " + party_name);
		       }
		}
	
	
	/*
	 * --------------------------------------------------------------------- METHOD TO GET ALL PARTY --------------------------------------------------------------------------
	 */
	
	
	@Override
	public List<Party> getAllPartys() {
		List<PartyEntity> partyEntityList = partyRepo.findAll();
		List<Party> partys = new ArrayList<Party>();
		for(PartyEntity partyEntity: partyEntityList) {
			partys.add(new Party(partyEntity.getPartyName(), partyEntity.getLeader(), partyEntity.getSymbol()));
		}
		return partys;
	}
		
	
	
	/*
	 *  ---------------------------------------------------------- METHOD TO DELETE LIST OF ALL CANDIDATES BY THEIR NAME --------------------------------------------------- 
     **/
	
	@Override
	public List<Candidate> deleteCandidate(String candidate_name) throws CandidateNotFoundException{
		List<CandidateEntity> candidateEntityList= candidateRepo.findByCandidateName(candidate_name);
		if(!candidateEntityList.isEmpty()) {
			for(CandidateEntity candidateEntity: candidateEntityList) {
			candidateRepo.delete(candidateEntity);
			}
			
			logger.info("Candidates deleted by candidate_name " + candidate_name + " is\n" + candidateEntityList);
			
			return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidateEntityList);
		}
		else {
			
			logger.error("Candidate by candidate_name " + candidate_name + " is " + properties.getLog().getNotFound());
			throw new CandidateNotFoundException("Candidate_Name: " + candidate_name);
		}
		
	}
	
	
	
	/*
	 * -------------------------------------------------------- METHOD TO DELETE A CANDIDATE BY HIS ID ----------------------------------------------------------------------
     **/
	
	@Override
	public Candidate deleteById(Integer candidate_id) throws CandidateNotFoundException
	{
		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(candidate_id);
		if(opCandidateEntity.isPresent())
		{
			CandidateEntity candidateEntity = opCandidateEntity.get();
			candidateRepo.deleteById(candidate_id);
			
			logger.info("Candidate deleted by candidate_id " + candidate_id + " is\n" + candidateEntity);
			
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);
			
		}
		else 
		{
			logger.error("Candidate by candidate_id " + candidate_id + " is " + properties.getLog().getNotFound());
			
			throw new CandidateNotFoundException();
		}
	}



	/*
	 * ---------------------------------------------------------------------METHOD TO GET CANDIDATE NAME ------------------------------------------------------------
	 */
	@Override
	public List<String> getCandidateName() {
		return candidateRepo.getByCandidateName();
	}



	/*
	 * ----------------------------------------------------------------------- METHOD TO GET PARTY NAME --------------------------------------------------------------
	 */
	@Override
	public List<String> getPartyName() {
		return partyRepo.getByPartyName();
	}


	/*
	 * ------------------------------------------------------------------------METHOD TO GET CANDIDATE EMAIL ---------------------------------------------------------
	 */

	@Override
	public List<String> getEmail() {
		return candidateRepo.getByEmail();
	}


	/*
	 * -------------------------------------------------------------------------METHOD TO GET CANDIDATE CONTACT NUMBER-----------------------------------------------
	 */

	@Override
	public List<String> getNumber() {
		return candidateRepo.getByContactNumber();
	}

}
	
	


