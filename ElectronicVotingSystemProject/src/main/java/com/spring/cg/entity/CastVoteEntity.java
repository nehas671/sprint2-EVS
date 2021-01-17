package com.spring.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity
@Table(name="castvote")
public class CastVoteEntity
{
	//Primary Key
	@Id
	@GeneratedValue
	@Column(name="cast_id")
	private int castId;
	
	@Column(name="election_name")
	private String electionName;
	
	@Column(name="state")
	private String state;
	
	@Column(name="constituency")
	private String constituency;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="candidate_name")
	private String candidateName;
	
	@Column(name="party_name")
	private String partyName;
	
	@Column(name="voter_id")
	private Integer voterId;

	//Default Constructor
	public CastVoteEntity() {
		super();
	}

	//Parameterized constructor to get candidate list
	public CastVoteEntity(String candidate_name, String party_name) {
		super();
		this.candidateName = candidate_name;
		this.partyName = party_name;
	}

	//Parameterized constructor
	public CastVoteEntity(String election_name, String state, String constituency, LocalDate date, String candidate_name, String party_name, Integer voter_id) {
		super();
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.candidateName = candidate_name;
		this.partyName = party_name;
		this.voterId = voter_id;
	}

	//Getters and Setters
	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String election_name) {
		this.electionName = election_name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidate_name) {
		this.candidateName = candidate_name;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String party_name) {
		this.partyName = party_name;
	}

	public Integer getVoterId() {
		return voterId;
	}

	public void setVoterId(Integer voter_id) {
		this.voterId = voter_id;
	}

	//ToString method for CastVoteEntity
	@Override
	public String toString() {
		return "CastVoteEntity [castId=" + castId + ", election_name=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", date=" + date + ", candidate_name=" + candidateName
				+ ", party_name=" + partyName +"]";
	}
	
}
