package com.spring.cg.testjson;

//import java.time.LocalDate;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.cg.entity.PartysEntity;
import com.spring.cg.json.Partys;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Election {

	
	private Long electionId;
	
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
	@ApiModelProperty(value="Election constituency ")
	private String constituency;
	
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value="Election date ")
	private Date date;
	
	private Set<Partys> parties = new HashSet<Partys>();
	
	
	public Election() {
		super();
	}
	public Election(String election_name, String state, String constituency,  Date date) {
		super();
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}
	public Election(Long electionId, String election_name, String state, String constituency,  Date date) {
		super();
		this.electionId = electionId;
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}
	
	public Election(Long electionId, String election_name, String state, String constituency,  Date date,Set<Partys> parties) {
		super();
		this.electionId = electionId;
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.parties=parties;
	}
	
	
	public Long getElectionId() {
		return electionId;
	}
	public void setElectionId(Long electionId) {
		this.electionId = electionId;
	}
	public String getElection_name() {
		return electionName;
	}
	public void setElection_name(String election_name) {
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
	public  Date getDate() {
		return date;
	}
	public void setDate( Date date) {
		this.date = date;
	}
	public Set<Partys> getParties() {
		return parties;
	}
	public void setParties(Set<Partys> parties) {
		this.parties = parties;
	}
	
}
