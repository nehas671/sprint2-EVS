package com.spring.cg.service;

import java.util.List;

import javax.validation.Valid;

import com.spring.cg.json.Election;
import com.spring.cg.json.Partys;

public interface PartyService {


	Partys createParty(Partys party);

	List<Partys> getAllParties();

	List<Election> UpdateElection( @Valid Partys party);

	

}
