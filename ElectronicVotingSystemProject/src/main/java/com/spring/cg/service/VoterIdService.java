package com.spring.cg.service;

import java.util.List;
import java.util.Optional;

import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.entity.VoterIdEntity;
import com.spring.cg.entity.VoterRequestEntity;
import com.spring.cg.json.VoterId;
import com.spring.cg.json.VoterRequest;

public interface VoterIdService {
	public VoterId getByApplicationId(Long id) throws UserNotFoundException;
	
	public VoterIdEntity getByEamilId(String emailId) throws UserNotFoundException;

	public List<VoterIdEntity> getAllRequests() throws UserNotFoundException;

	public List<VoterId> getByDistrict(String district) throws UserNotFoundException;

	public List<VoterIdEntity> getByStatus(String status) throws UserNotFoundException;
	
	public List<String> getAllDistricts();
	
	public List<String> getAllStatus();
}
