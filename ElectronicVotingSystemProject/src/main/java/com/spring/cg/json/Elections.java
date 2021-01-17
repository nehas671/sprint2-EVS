package com.spring.cg.json;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Elections
{
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
	private LocalDate date;
	private Set<Partyz> party;
	
	public Elections() {
		super();
	}
	
	public Elections(String election_name, String state, String constituency, LocalDate date) {
		super();
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}
	
	public Elections(Long electionId, String electionName, String state, String constituency, LocalDate date) {
		super();
		this.electionId = electionId;
		this.electionName = electionName;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}

	public Elections(String election_name, String state, String constituency, LocalDate date, Set<Partyz> party) {
		super();
		this.electionName = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.party = party;
	}
	
	public Elections(Long electionId, String electionName, String state, String constituency, LocalDate date, Set<Partyz> party) {
		super();
		this.electionId = electionId;
		this.electionName = electionName;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
		this.party = party;
	}

	public Long getElectionId() {
		return electionId;
	}
	
	public void setElectionId(Long election_id) {
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
	
	public Set<Partyz> getParty() {
		return party;
	}
	
	public void setParty(Set<Partyz> party) {
		this.party = party;
	}
	
	@Override
	public String toString() {
		return "Election [election_id=" + electionId + ", election_name=" + electionName + ", state=" + state
				+ ", constituency=" + constituency + ", date=" + date + ", party=" + party + "]";
	}
}
