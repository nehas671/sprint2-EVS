package com.spring.cg.utils;

import java.util.ArrayList;
import java.util.List;

import com.spring.cg.entity.VoterIdEntity;
import com.spring.cg.json.VoterId;

public class VoterIdUtil {
	public static VoterId convertVoterIdEntityIntoVoterId(VoterIdEntity voterIdEntity) {
		VoterId voterId = new VoterId( voterIdEntity.getName(), voterIdEntity.getDistrict(),
				voterIdEntity.getConstituency(), voterIdEntity.getVoter_id(), voterIdEntity.getContact_no(),
				voterIdEntity.getStatus(), voterIdEntity.getDob(), voterIdEntity.getEmailId());
		return voterId;
	}

	public static VoterIdEntity convertVoterIdIntoVoterIdEntity(VoterId voterId) {
		return new VoterIdEntity( voterId.getName(), voterId.getDistrict(),
				voterId.getConstituency(), voterId.getVoter_id(), voterId.getContact_no(), voterId.getStatus(),
				voterId.getDob(), voterId.getEmailId());
	}

	public static List<VoterId> convertVoterIdEntityListIntoVoterIdList(List<VoterIdEntity> voterIdEntityList) {
		List<VoterId> voters = new ArrayList<VoterId>();
		for (VoterIdEntity voterEntity : voterIdEntityList) {
			voters.add(convertVoterIdEntityIntoVoterId(voterEntity));
		}
		return voters;
	}
}