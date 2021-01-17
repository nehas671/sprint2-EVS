package com.spring.cg.service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.spring.cg.entity.ElectionEntity;
import com.spring.cg.exception.ElectionNotFoundException;
import com.spring.cg.exception.InvalidStateException;
import com.spring.cg.json.Election;
import com.spring.cg.json.State;

public interface ElectionService {

	Election createElection(Election election) throws InvalidStateException;

	List<Election> getAllElection() throws ElectionNotFoundException;

	boolean deleteByElectionId(Long electionId) throws ElectionNotFoundException;

	List<State> getAllStates();

	List<Election> getAllElectionByState(String state) throws ElectionNotFoundException;

	List<Election> getAllElectionByElectionName(String electionName) throws ElectionNotFoundException;

	List<Election> getAllElectionByDate(LocalDate startdate) throws ElectionNotFoundException;

	List<Election> getAllElectionByConstituency(String constituency) throws ElectionNotFoundException;

	List<String> getAllElectionName();

	List<String> getAllConstituency();

	List<String> getAllElectionState();

	List<LocalDate> getAllDate();

	

	

	

	

}
