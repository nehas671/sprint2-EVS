package com.spring.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;



import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity
@Table(name="election")
public class ElectionEntity {
	
	@Id
	@GeneratedValue
	@Column(name="election_id")
	private Long electionId;

	@Column(name="election_name")
	private String electionName;
	
	@Column(name="state")
	private String state;
	
	@Column(name="constituency")
	private String constituency;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="date")
	private LocalDate date;
	
	
	/*---Election to party many to many---*/
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="election_party", joinColumns = { @JoinColumn(name = "election_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "party_name") })
	private Set<PartysEntity> party=new HashSet<PartysEntity>();


	
	
	public ElectionEntity() {
		super();
	}
	
	public ElectionEntity(Long electionId,java.lang.String electionName, java.lang.String state, java.lang.String constituency, LocalDate date) {
		super();
	    this.electionId=electionId;
		this.electionName = electionName;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		
	}

	public ElectionEntity(String election_name, String state, String constituency, LocalDate date,Set<PartysEntity> parties) {
		super();
	
	
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.party = parties;
		
	}
	
	
	
	

	public ElectionEntity(String election_name, String state, String constituency, LocalDate date) {
		super();
	
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		
	}
	
	/*
	 * Getter and Setter
	 * */

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	
	public Set<PartysEntity> getParty() {
		return party;
	}

	public void setParty(Set<PartysEntity> party) {
		this.party = party;
	}

	
	
	@Override
	public String toString() {
		return "ElectionEntity [election_id=" + electionId + ", election_name=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", date=" + date + "]";
	}
	
	
	
	
}