package com.spring.cg.utils;


import com.spring.cg.entity.VoterRequestEntity;
import com.spring.cg.json.VoterRequest;

public class VoterRequestUtil {
	
	public static VoterRequestEntity convertVoterRequestIntoVoterRequestEntity(VoterRequest voterRequest) {
		VoterRequestEntity voterRequestEntity = new VoterRequestEntity(voterRequest.getVoterId(),voterRequest.getName(),
				voterRequest.getDistrict(),voterRequest.getConstituency(),voterRequest.getEmailId(),voterRequest.getApplicationStatus(),
				voterRequest.getContactNumber(),voterRequest.getDob());
		return voterRequestEntity;
	}
	
	
	public static VoterRequest convertVoterRequestEntityIntoVoterRequest(VoterRequestEntity voterRequestEntity) {
		VoterRequest voterRequest = new VoterRequest(voterRequestEntity.getVoterId(),voterRequestEntity.getName(),voterRequestEntity.getEmailId(),voterRequestEntity.getDob(),
				voterRequestEntity.getDistrict(),voterRequestEntity.getConstituency(),voterRequestEntity.getApplicationStatus(),
				voterRequestEntity.getContactNumber());
		
		return voterRequest;

	}

}
