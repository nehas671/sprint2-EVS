package com.spring.cg.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cg.Myproperties;
import com.spring.cg.entity.CandidateEntity;
import com.spring.cg.exception.CandidateNotFoundException;
import com.spring.cg.json.Candidate;
import com.spring.cg.repo.CandidateRepo;
import com.spring.cg.repo.UpdateAndDeleteCandidateRepo;
import com.spring.cg.utils.CandidateUtil;






@Service
public class UpdateAndDeleteCandidateServiceImpl implements UpdateAndDeleteCandidateService {
	
	
	private static final Logger logger = LogManager.getLogger(UpdateAndDeleteCandidateServiceImpl.class);
	
	
	@Autowired
	private UpdateAndDeleteCandidateRepo updateAndDeleteCandidateRepo;
	
	@Autowired
	Myproperties properties;
	
	@Autowired
	CandidateRepo candidateRepo;
	


	
	/***************************Method to Get details of Candidate by entering its Email Id********************************/
	@Override
	public Candidate getCandidateByEmail(String email) throws  CandidateNotFoundException{
		
		
		//calling findByEmail function of UpdateAndDeleteCandidateRepo
		CandidateEntity candidateEntity = updateAndDeleteCandidateRepo.findByEmail(email);
		
		
		
		if(candidateEntity!=null)
		{
			
			logger.info("Candidate details");
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
			
			
			 
		}
		
		else
		{
			logger.error(properties.getLog().getNoCandidate()+" entered email "+email);
			 throw new CandidateNotFoundException("No candidate for Email Id "+email);
			
			
		}
		
		
	}
	 
/*

	***************************Method to update Candidate Name by entering  Email Id********************************

	@Override
	public Candidate updateCandidateName(String email, String name) throws CandidateNotFoundException
	{
		
		 
			//calling findByEmail function of UpdateAndDeleteCandidateRepo
			CandidateEntity candidateEntity = updateAndDeleteCandidateRepo.findByEmail(email);
			
			
			//Checking if enetered email is available or not 
			if( candidateEntity!=null)
			{
				
				//Calling setCandidateName function to update candidate name
				candidateEntity.setCandidateName(name);
				candidateEntity=updateAndDeleteCandidateRepo.save(candidateEntity);
				logger.info(properties.getLog().getForUpdating()+" name "+name);
				return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
				
			}
			
			else
				logger.error(properties.getLog().getNoCandidate()+" entered email "+email);
				throw new CandidateNotFoundException("NO Candidate for Email Id "+email);
		
	}
	
	@Override
	public Candidate updateAddress(String email, String address) throws CandidateNotFoundException 
	{
		
		 
		//calling findByEmail function of UpdateAndDeleteCandidateRepo
		CandidateEntity candidateEntity =  updateAndDeleteCandidateRepo.findByEmail(email);
	
		
		//Checking if enetered email is available or not 
		if(candidateEntity!=null)
		{
			
			
			//Calling setAddress function to update candidate address
			candidateEntity.setAddress(address);
			candidateEntity=updateAndDeleteCandidateRepo.save(candidateEntity);
			logger.info(properties.getLog().getForUpdating()+" Address "+address);
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
			
		}
		
		else
			logger.error(properties.getLog().getNoCandidate()+" entered email "+email);
			throw new CandidateNotFoundException("NO Candidate for Email Id "+email);
	
	}

	
	@Override
	public Candidate updateAge(String email, int age) throws CandidateNotFoundException, InvalidAgeException 
	{
		
		 
		//calling findByEmail function of UpdateAndDeleteCandidateRepo
		CandidateEntity candidateEntity = updateAndDeleteCandidateRepo.findByEmail(email);
		
		
		//Checking if enetered email is available or not 
		if(candidateEntity!=null)
		{
			
			
			if(age>=25) 
			{
				
				//Calling setCandidateAge function to update candidate age
				candidateEntity.setAge(age);
				candidateEntity=updateAndDeleteCandidateRepo.save(candidateEntity);
				logger.info(properties.getLog().getForUpdating()+" Age "+age);
				return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
			}
			else
			{
				
				logger.error("Invalid Age");
				throw new InvalidAgeException("Age sgould be greater than 25");	
			}	
		}
		
		else
			logger.error(properties.getLog().getNoCandidate()+" entered email "+email);
			throw new CandidateNotFoundException("NO Candidate for Email Id "+email);
	
	}
		
	
	@Override
	public Candidate updateContactNumber(String email, String contactnumber) throws CandidateNotFoundException 
	{
		
		 
		//calling findByEmail function of UpdateAndDeleteCandidateRepo
		CandidateEntity candidateEntity = updateAndDeleteCandidateRepo.findByEmail(email);
		
		
		//Checking if enetered email is available or not 
		if(candidateEntity!=null)
		{
			
			//Calling setCandidateNumber function to update candidate number
			candidateEntity.setContact_number(contactnumber);
			candidateEntity=updateAndDeleteCandidateRepo.save(candidateEntity);
			logger.info(properties.getLog().getForUpdating()+" Contact Number "+contactnumber);
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
			
		}
		
		else
			logger.error(properties.getLog().getNoCandidate()+" entered email "+email);
			throw new CandidateNotFoundException("NO Candidate for Email Id "+email);
	
	}
	*/
	
	@Override
	public Candidate updateCandidate(Integer id,Candidate candidate) throws CandidateNotFoundException {
	
		
	 
		Optional<CandidateEntity> candidateEntityOp = updateAndDeleteCandidateRepo.findById(id);
		
		
		if(candidateEntityOp.isPresent())		
		
		{
			
			CandidateEntity candidateEntity = candidateEntityOp.get();
			candidateEntity.setCandidateName(candidate.getCandidateName());
			candidateEntity.setAddress(candidate.getAddress());
			candidateEntity.setAge(candidate.getAge());
			candidateEntity.setContactNumber(candidate.getContactNumber());
			candidateEntity.setEmail(candidate.getEmail());
			//candidateEntity.setParty(candidateEntity.getParty());

			
			System.out.println("candidate entity"+candidateEntity);
			candidateEntity=updateAndDeleteCandidateRepo.save(candidateEntity);
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
			
		}
		
		else
			logger.error(properties.getLog().getNoCandidate());
			throw new CandidateNotFoundException("Candidate not found");
		

	}
	
	/*

	public Candidate update(Integer candidateId, Candidate candidate) throws CandidateNotFoundException 
	{
		
		 
		//calling findByEmail function of UpdateAndDeleteCandidateRepo
		CandidateEntity candidateEntity =  findByid(candidateId);
	
		
		//Checking if enetered email is available or not 
		if(candidateEntity!=null)
		{
			
			
			//Calling setAddress function to update candidate address
			candidateEntity.setAddress();
			candidateEntity=updateAndDeleteCandidateRepo.save(candidateEntity);
			logger.info(properties.getLog().getForUpdating()+" Address "+address);
			return CandidateUtil.convertCandidateEntityIntoCandidate(candidateEntity);	
			
		}
		
		else
			logger.error(properties.getLog().getNoCandidate()+" entered email "+email);
			throw new CandidateNotFoundException("NO Candidate for Email Id "+email);
	
	}*/


	
	@Override
	public  List<Candidate> deleteById(Integer id) throws CandidateNotFoundException
	{
		
		//calling findByEmail function of UpdateAndDeleteCandidateRepo
		Optional<CandidateEntity> candidateEntity = updateAndDeleteCandidateRepo.findById(id);
		
		if(candidateEntity!=null)
		{
	
			//Calling deleteByEmail function to delete candidate details
			updateAndDeleteCandidateRepo.deleteById(id);
			logger.info(properties.getLog().getDelete());
			List<CandidateEntity> candidate = candidateRepo.findAll();
			return CandidateUtil.convertCandidateEntityListIntoCandidateList(candidate);	
		}
		else
		{
			logger.error(properties.getLog().getNoCandidate());
			throw new CandidateNotFoundException("Candidate not found");
		}
				
	}





}
