package com.spring.cg.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.entity.PartysEntity;
import com.spring.cg.entity.StateEntity;
import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;
import com.spring.cg.json.State;

public class ElectionUtil {


	public static Partys convertPartysEntityIntoParty(PartysEntity partyEntity) {
		return new Partys( partyEntity.getParty_name(),partyEntity.getLeader(), partyEntity.getSymbol());
	}
	
	public static PartysEntity convertPartyIntoPartysEntity(Partys party) {
		return new PartysEntity(party.getParty_name(),party.getLeader(),party.getSymbol());
	}
	
	
	
	public static Election convertElectionEntityIntoElection(ElectionEntity electionEntity) {
		Set<PartysEntity> partysEntities = electionEntity.getParty();
		Set<Partys> party = new HashSet<Partys>();
		Election election = new Election(electionEntity.getElection_name(), electionEntity.getState(), electionEntity.getConstituency(),electionEntity.getDate());
		for(PartysEntity partysEntity: partysEntities)
			party.add(convertPartysEntityIntoParty(partysEntity));
		election.setElectionId(electionEntity.getElectionId());
		election.setParties(party);
		return election;
	}

	public static ElectionEntity convertElectionIntoElectionEntity(Election election) {
		ElectionEntity electionEntity = new ElectionEntity(election.getElection_name(), election.getState(), election.getConstituency(),election.getDate());
		Set<ElectionEntity> electionEntities = new HashSet<ElectionEntity>();
		electionEntities.add(electionEntity);
		Set<Partys> parties = election.getParties();
		Set<PartysEntity> partyEntities = new HashSet<PartysEntity>();
		for(Partys party: parties)
			partyEntities.add(convertPartyIntoPartysEntity(party));
		electionEntity.setParty(partyEntities);
		return electionEntity;
	}

	public static List<Election> convertElectionEntityListIntoElectionList(List<ElectionEntity> electionEntityList) {
		List<Election> elections = new ArrayList<Election>();
		for(ElectionEntity electionEntity: electionEntityList) {
			elections.add(convertElectionEntityIntoElection(electionEntity));
		}
		return elections;
	}
	
	
	public static List<State> convertStateEntityListIntoStateList(List<StateEntity> stateEntityList) {
		List<State> states = new ArrayList<State>();
		for(StateEntity stateEntity: stateEntityList) {
			states.add(convertStateEntityIntoState(stateEntity));
		}
		return states;
	}
	
	
	
	public static State convertStateEntityIntoState(StateEntity stateEntity) {
		return new State( stateEntity.getState());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
