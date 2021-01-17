package com.spring.cg.json;


import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CastVote
{
	private int castId;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Election Name")
	private String electionName;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Election State")
	private String state;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Election Constituency")
	private String constituency;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value="Date of Election")
	private LocalDate date;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Name of Candidate")
	private String candidateName;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Name of Party")
	private String partyName;
	
	@NotNull
	@Min(value=1)
	@ApiModelProperty(value="Voter ID")
	private int voterId;
	
	//Default Constructor
	public CastVote() {
		super();
	}
	
	//Parameterized constructor for Candidate List
	public CastVote(String candidate_name, String party_name) {
		super();
		this.candidateName = candidate_name;
		this.partyName = party_name;
	}

	//Parameterized Constructor
	public CastVote(int castId, String election_name, String state, String constituency, LocalDate date, String candidate_name,
			String party_name, int voter_id) {
		super();
		this.castId=castId;
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.candidateName = candidate_name;
		this.partyName = party_name;
		this.voterId = voter_id;
	}
	
	public CastVote(String election_name, String state, String constituency, LocalDate date, String candidate_name, String party_name, int voter_id) {
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
	
	public int getVoterId() {
		return voterId;
	}
	
	public void setVoterId(int voter_id) {
		this.voterId = voter_id;
	}

	//ToString for CastVote POJO
	@Override
	public String toString() {
		return "CastVote [castId=" + castId + ", election_name=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", date=" + date + ", candidate_name=" + candidateName
				+ ", party_name=" + partyName + ", voter_id=" + voterId + "]";
	}
	
}
