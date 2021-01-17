package com.spring.cg.service;

import java.util.List;

import javax.validation.Valid;

import com.spring.cg.exception.PartyNotFoundException;
import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;

public interface PartyService {


	Partys createParty(Partys party);

	List<Partys> getAllParties();

	List<Election> UpdateElection( @Valid Partys party);

	Partys getPartyByPartyName(String party_name) throws PartyNotFoundException;

	List<Partys> getAllPartyBySymbol(String symbol) throws PartyNotFoundException;

	List<Partys> getAllPartyByLeaderName(String leader) throws PartyNotFoundException;

	List<String> getSymbol() throws PartyNotFoundException;

	List<String> getLeaderName() throws PartyNotFoundException;

	List<String> getPartyName() throws PartyNotFoundException;

	

}
