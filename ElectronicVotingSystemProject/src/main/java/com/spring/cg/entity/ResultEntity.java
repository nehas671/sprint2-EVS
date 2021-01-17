package com.spring.cg.entity;



import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity
@Table(name="result")         //table name from database

public class ResultEntity
{

	@Id                       		//primary key   
	@GeneratedValue          		//auto Generated
	@Column(name="result_id")
	private int result_id;

	@Column(name="election_name")
	private String election_name;

	
	@Column(name="state")
	private String state;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="constituency")
	private String constituency;
	
	@Column(name="candidate_name")
	private String candidate_name;
	
	@Column(name="party_name")
	private String party_name;
	
	@Column(name="votes")
	private long votes;

	public ResultEntity(int result_id, String election_name, String state, LocalDate date, String constituency,
			String candidate_name, String party_name, long votes)			//Parameterize Constructor
	{
		super();
		this.result_id = result_id;
		this.election_name = election_name;
		this.state = state;
		this.date = date;
		this.constituency = constituency;
		this.candidate_name = candidate_name;
		this.party_name = party_name;
		this.votes = votes;
	}

	public ResultEntity(String election_name, String state, LocalDate date, String constituency, String candidate_name,
			String party_name, long votes)  							 //Parameterize Constructor	
	{
		super();
		this.election_name = election_name;
		this.state = state;
		this.date = date;
		this.constituency = constituency;
		this.candidate_name = candidate_name;
		this.party_name = party_name;
		this.votes = votes;
	}

	public ResultEntity()  								//Default Constructor
	{
		super();
	}
									//Setters and Getters
	public int getResult_id() 
	{
		return result_id;
	}

	public void setResult_id(int result_id)
	{
		this.result_id = result_id;
	}

	public String getElection_name() {
		return election_name;
	}

	public void setElection_name(String election_name) 
	
	{
		this.election_name = election_name;
	}

	public String getState() 
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date) 
	{
		this.date = date;
	}

	public String getConstituency() 
	{
		return constituency;
	}

	public void setConstituency(String constituency)
	{
		this.constituency = constituency;
	}

	public String getCandidate_name() 
	{
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name)
	{
		this.candidate_name = candidate_name;
	}

	public String getParty_name() 
	{
		return party_name;
	}

	public void setParty_name(String party_name) 
	{
		this.party_name = party_name;
	}

	public long getVotes()
	{
		return votes;
	}

	public void setVotes(long votes) 
	{
		this.votes = votes;
	}

	@Override
	public String toString()
	{
		return "ResultEntity [result_id=" + result_id + ", election_name=" + election_name + ", state=" + state
				+ ", date=" + date + ", constituency=" + constituency + ", candidate_name=" + candidate_name
				+ ", party_name=" + party_name + ", votes=" + votes + "]";
	}
	
	
	

}
