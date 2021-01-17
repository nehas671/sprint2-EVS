package com.spring.cg.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.spring.cg.Myproperties;
import com.spring.cg.entity.VoterRequestEntity;
import com.spring.cg.exception.RequestNotApproved;
import com.spring.cg.exception.UserNotFoundException;
import com.spring.cg.json.VoterRequest;
import com.spring.cg.repo.VoterRequestRepo;
import com.spring.cg.utils.VoterRequestUtil;

@Service
public class VoterRequestServiceImpl implements VoterRequestService {

	private static final Logger logger = LogManager.getLogger(VoterRequestServiceImpl.class);
	@Autowired
	VoterRequestRepo voterRequestRepo;
	
	@Autowired
	Myproperties properties;
	
	public int ConvertDobIntoAge(Date dob) {
		
		Calendar c = Calendar.getInstance();
		  c.setTime(dob);
		  int year = c.get(Calendar.YEAR);
		  int month = c.get(Calendar.MONTH) + 1;
		  int date = c.get(Calendar.DATE);
		  LocalDate localDob = LocalDate.of(year, month, date);
		  LocalDate now = LocalDate.now();
		  Period diff = Period.between(localDob, now);
		  return diff.getYears();
		
	}
	
	@Override
	public VoterRequest approveVoterRequest(VoterRequest voterRequest ) throws RequestNotApproved {
		Optional<VoterRequestEntity> voterRequestOp = voterRequestRepo.findByEmailId(voterRequest.getEmailId());
		VoterRequestEntity voterRequestEntity = voterRequestOp.get();
		int age = ConvertDobIntoAge(voterRequest.getDob());
		if(voterRequestOp.isPresent() && age>=18) {
			voterRequestEntity.setApplicationStatus(properties.getLog().getAccepted());
			logger.info("Approved Request",voterRequestEntity);
		}
		else {
		voterRequestEntity.setApplicationStatus(properties.getLog().getRejected());
		logger.error("Rejected Request",voterRequestEntity);
		throw new RequestNotApproved("Not Eligible");
		}
		
		return null;
	}

	@Override
	public VoterRequest addVoterRequest(VoterRequest voterRequest) {
		VoterRequestEntity voterRequestEntity = VoterRequestUtil.convertVoterRequestIntoVoterRequestEntity(voterRequest);
		if(voterRequest!=null) {
		voterRequestEntity = voterRequestRepo.save(voterRequestEntity);
		logger.info("Adding Voter request",voterRequestEntity);
		return VoterRequestUtil.convertVoterRequestEntityIntoVoterRequest(voterRequestEntity);
		}
		
		return null;
	}

	@Override
	public VoterRequest approveVoterRequestt(int id) {
		Optional<VoterRequestEntity> voterEntity = voterRequestRepo.findById(id);
		VoterRequestEntity voterRequestEntity = voterEntity.get();
		int age = ConvertDobIntoAge(voterRequestEntity.getDob());
		if(voterEntity!=null&&age>=18) {
			voterRequestEntity.setApplicationStatus(properties.getLog().getAccepted());
			logger.info("Approved Request",voterRequestEntity);
			voterRequestEntity = voterRequestRepo.save(voterRequestEntity);
			return VoterRequestUtil.convertVoterRequestEntityIntoVoterRequest(voterRequestEntity);
			
		}
		else
		{
			voterRequestEntity.setApplicationStatus(properties.getLog().getRejected());
			voterRequestEntity = voterRequestRepo.save(voterRequestEntity);
			return VoterRequestUtil.convertVoterRequestEntityIntoVoterRequest(voterRequestEntity);

		}
		
	}

}
