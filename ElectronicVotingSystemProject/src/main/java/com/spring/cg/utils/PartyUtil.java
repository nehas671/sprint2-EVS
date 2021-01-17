
package com.spring.cg.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.entity.PartysEntity;
import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;


public class PartyUtil {
	
	public static ElectionEntity convertElectionIntoElectionEntity(Election election) {
		return new ElectionEntity( election.getElection_name(), election.getState(), election.getConstituency(), election.getDate());
	}
	public static Election convertElectionEntityIntoElection(ElectionEntity electionEntity) {
		return new Election(electionEntity.getElectionId(), electionEntity.getElection_name(), electionEntity.getState(), electionEntity.getConstituency(), electionEntity.getDate());
	}
	
	

	public static Partys convertPartysEntityIntoParty(PartysEntity partyEntity) {
		Set<ElectionEntity> electionEntities = partyEntity.getElection();
		Set<Election> election = new HashSet<Election>();
		Partys party = new Partys(partyEntity.getParty_name(), partyEntity.getLeader(), partyEntity.getSymbol());
		for(ElectionEntity electionEntity: electionEntities)
			election.add(convertElectionEntityIntoElection(electionEntity));
		party.setParty_name(party.getParty_name());
		party.setElections(election);
		return party;
	}
	
	
	
	public static PartysEntity convertPartyIntoPartysEntity(Partys party) {
		PartysEntity partysEntity = new PartysEntity(party.getParty_name(), party.getLeader(), party.getSymbol());
		Set<PartysEntity> partyEntities = new HashSet<PartysEntity>();
		partyEntities.add(partysEntity);
		Set<Election> elections = party.getElections();
		Set<ElectionEntity> electionEntities = new HashSet<ElectionEntity>();
		for(Election election: elections)
			electionEntities.add(convertElectionIntoElectionEntity(election));
		partysEntity.setElection(electionEntities);
		return partysEntity;
	}

	public static List<Partys> convertPartysEntityListIntoPartyList(List<PartysEntity> partysEntityList) {
		List<Partys> partys = new ArrayList<Partys>();
		for(PartysEntity partyEntity: partysEntityList) {
			partys.add(convertPartysEntityIntoParty(partyEntity));
		}
		return partys;
	}
	
	
	public static List<Election> convertElectionEntityListIntoElectionList(List<ElectionEntity> electionEntityList) {
		List<Election> elections = new ArrayList<Election>();
		for(ElectionEntity electionEntity: electionEntityList) {
			elections.add(convertElectionEntityIntoElection(electionEntity));
		}
		return elections;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

