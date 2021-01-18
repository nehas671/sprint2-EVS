package com.spring.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.Myproperties;
import com.spring.cg.entity.VoterIdEntity;
import com.spring.cg.entity.VoterRequestEntity;
import com.spring.cg.json.VoterId;
import com.spring.cg.json.VoterRequest;
import com.spring.cg.repo.VoterIdRepo;
import com.spring.cg.utils.VoterIdUtil;

@SpringBootApplication

public class VoterIdServiceImpl implements VoterIdService {
	private static final Logger logger = LogManager.getLogger(VoterIdServiceImpl.class);
	@Autowired
	private VoterIdRepo voterRepo;

	@Autowired
	Myproperties properties;

	/*
	 * To view voter id of the user after request gets approved
	 */
	@Override
	public VoterId getByApplicationId(Long user) throws UserNotFoundException {
		Optional<VoterIdEntity> entityList = voterRepo.findById(user);
		if (entityList.isPresent()) {
			VoterIdEntity voterEntity = entityList.get();
			if (voterEntity.getStatus().equals(properties.getLog().getPending())
					|| voterEntity.getStatus().equals(properties.getLog().getReject())) {
				logger.error("User " + properties.getLog().getFail());
				throw new UserNotFoundException("Application not approved");
			}
			logger.info(properties.getLog().getFound());
			return VoterIdUtil.convertVoterIdEntityIntoVoterId(voterEntity);
		} else {
			logger.error("User " + properties.getLog().getFail());
			throw new UserNotFoundException("User not found ");
		}
	}

	/*
	 * To view all the voter requests in the database
	 */
	@Override
	public List<VoterIdEntity> getAllRequests() throws UserNotFoundException {
		List<VoterIdEntity> entityList = voterRepo.findAll();
		if (entityList == null || entityList.isEmpty()) {
			logger.error("Voter Requests " + properties.getLog().getFail());
			throw new UserNotFoundException("No voter requests found");
		} else {
			logger.info(properties.getLog().getFound());
			return entityList;
		}
	}
	/*
	 * To view the voter requests in the given district
	 */

	@Override
	public List<VoterId> getByDistrict(String district) throws UserNotFoundException {
		List<VoterIdEntity> entityList = voterRepo.findByDistrict(district);
		if (entityList == null || entityList.isEmpty()) {
			logger.error("Voter Requests " + properties.getLog().getFail());
			throw new UserNotFoundException("No requests found for the district");

		} else {
			logger.info(properties.getLog().getFound());
			return VoterIdUtil.convertVoterIdEntityListIntoVoterIdList(entityList);
		}
	}

	/*
	 * To view the voter requests for the given status
	 */
	@Override
	public List<VoterIdEntity> getByStatus(String status) throws UserNotFoundException {
		List<VoterIdEntity> entityList = voterRepo.findByStatus(status);
		if (entityList == null || entityList.isEmpty()) {
			logger.error("Voter Requests " + properties.getLog().getFail());
			throw new UserNotFoundException("No requests found for the Status");

		} else {
			logger.info(properties.getLog().getFound());
			return entityList;
		}
	}

	@Override
	public List<String> getAllDistricts() {
		List<String> entityList =voterRepo.findAllDistricts();
		return entityList;
	}

	@Override
	public List<String> getAllStatus() {
		List<String> entityList =voterRepo.findAllStatus();
		return entityList;
	}

	@Override
	public VoterIdEntity getByEamilId(String emailId) throws UserNotFoundException {
		VoterIdEntity entityList=voterRepo.findByEmailId(emailId);
		if (entityList!=null) {
			if (entityList.getStatus().toUpperCase().equals(properties.getLog().getPending())
					|| entityList.getStatus().equals(properties.getLog().getRejected())) {
			
				logger.error("User " + properties.getLog().getFail());
				throw new UserNotFoundException("Application not approved");
			}
			logger.info(properties.getLog().getFound());
			return entityList;
		} 
		
		else {
			logger.error("User " + properties.getLog().getFail());
			throw new UserNotFoundException("User not found ");
		}
}
}
