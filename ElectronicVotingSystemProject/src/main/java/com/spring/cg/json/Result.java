package com.spring.cg.json;



import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)  //To Ignore Unknows Value
public class Result 
{
	@ApiModelProperty(value="Result Id")  //Swagger Documentation
	private int result_id;
	@NotNull								//Validators
	@NotBlank
	@ApiModelProperty(value="Name Of the Election")
	private String election_name;
	
	@NotNull
	@NotBlank								//Validators
	@ApiModelProperty(value="State Name Of the Election")
	private String state;
	
	@ApiModelProperty(value="Date of the Election")    
	private LocalDate date;
	
	@NotNull
	@NotBlank							//Validators
	@ApiModelProperty(value="Constituency Name of the Election")
	private String constituency;
	
	@NotNull
	@NotBlank					//Validators
	@ApiModelProperty(value="Candidate name of the Election")
	private String candidate_name;
	
	@NotNull
	@NotBlank						//Validators
	@ApiModelProperty(value="Party name of the Election")
	private String party_name;
	
	@NotBlank
	@NotNull						//Validators
	@ApiModelProperty(value="Total Votes of the Candidate")
	private long votes;
	
	public Result(int result_id, String election_name, String state, LocalDate date, String constituency,
			String candidate_name, String party_name, long votes)		//Parameterize Constructor
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
	public Result()				//Default Constructor
	{
		super();
	}
	public Result(String election_name, String state, LocalDate date, String constituency, String candidate_name,
			String party_name, long votes)  //Parameterize Constructor
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
	
	//Setters and Getters
	                    
	public int getResult_id()
	{
		return result_id;
	}
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	public String getElection_name() {
		return election_name;
	}
	public void setElection_name(String election_name) {
		this.election_name = election_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public String getCandidate_name() {
		return candidate_name;
	}
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public long getVotes() {
		return votes;
	}
	public void setVotes(long votes) {
		this.votes = votes;
	}
	
	@Override
	public String toString() {
		return "Result [result_id=" + result_id + ", election_name=" + election_name + ", state=" + state + ", date="
				+ date + ", constituency=" + constituency + ", candidate_name=" + candidate_name + ", party_name="
				+ party_name + ", votes=" + votes + "]";
	}
	
}
