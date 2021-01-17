package com.spring.cg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="party")
public class PartyEntity {
	@Id
	@Column(name="party_name")
	private String partyName;
	
	@Column(name="leader")
	private String leader;
	
	@Column(name="symbol")
	private String symbol;
	
	/*
     * ------------------------------------------------- CREATION OneToMany RELATION WITH CANDIDATE TABLE ---------------------------------------------------------------- 
     **/
	
	@OneToMany(cascade= {CascadeType.PERSIST}, fetch=FetchType.LAZY, mappedBy="party")
	private Set<CandidateEntity> candidate;

	/*
     * CONSTRUCTOR FOR PartyEntity CLASS 
     **/
	
	public PartyEntity() {}

	public PartyEntity(String partyName, String leader, String symbol) {
		super();
		this.partyName=partyName;
		this.leader = leader;
		this.symbol = symbol;
	}

	public PartyEntity(String partyName, String leader, String symbol, Set<CandidateEntity> candidate) {
		super();
		this.partyName = partyName;
		this.leader = leader;
		this.symbol = symbol;
		this.candidate = candidate;
	}
	
	/*
     * ----------------------------------------------------- GETTER AND SETTER FOR ABOVE VARIABLES -----------------------------------------------------------------------
     **/
	
	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName= partyName;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Set<CandidateEntity> getCandidate() {
		return candidate;
	}

	public void setCandidate(Set<CandidateEntity> candidate) {
		this.candidate = candidate;
	}

	/*
	 *  ------------------------------------------------------- ToString METHOD FOR ABOVE VARIABLES ---------------------------------------------------------------------
     **/
	
	@Override
	public String toString() {
		return "PartyEntity [partyname=" + partyName + ", leader=" + leader + ", symbol=" + symbol +  "]";
	}
	
}

