package com.spring.cg.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity
@Table(name="election")
public class ElectionsEntity
{
	@Id
	@GeneratedValue
	@Column(name="election_id")
	private int electionId;
	
	@Column(name="election_name")
	private String electionName;
	
	@Column(name="state")
	private String state;
	
	@Column(name="constituency")
	private String constituency;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="date")
	private LocalDate date;
	
	//Many to many mapping between election and party entities
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="election_party", joinColumns = {@JoinColumn(name = "election_id")}, inverseJoinColumns= {@JoinColumn(name="party_name")})
	private Set<PartyzEntity> party = new HashSet<PartyzEntity>();
	
	public ElectionsEntity() {
		super();
	}

	public ElectionsEntity(String election_name, String state, String constituency, LocalDate date) {
		super();
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}

	public ElectionsEntity(String election_name, String state, String constituency, LocalDate date, Set<PartyzEntity> party) {
		super();
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.party = party;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int election_id) {
		this.electionId = election_id;
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

	public Set<PartyzEntity> getParty() {
		return party;
	}

	public void setParty(Set<PartyzEntity> party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "ElectionEntity [election_id=" + electionId + ", election_name=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", date=" + date + ", party=" + party + "]";
	}
	
}
