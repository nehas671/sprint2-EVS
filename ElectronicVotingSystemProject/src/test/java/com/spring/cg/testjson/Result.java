package com.spring.cg.testjson;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Result 
{
	@ApiModelProperty(value="Result Id")
	private int result_id;
	@ApiModelProperty(value="Name Of the Election")
	private String election_name;
	@ApiModelProperty(value="State Name Of the Election")
	private String state;
	@ApiModelProperty(value="Date of the Election")
	private Date date;
	@ApiModelProperty(value="Constituency Name of the Election")
	private String constituency;
	@ApiModelProperty(value="Candidate name of the Election")
	private String candidate_name;
	@ApiModelProperty(value="Party name of the Election")
	private String party_name;
	@ApiModelProperty(value="Total Votes of the Candidate")
	private long votes;
	public Result(int result_id, String election_name, String state, Date date, String constituency,
			String candidate_name, String party_name, long votes) {
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
	public Result() {
		super();
	}
	public Result(String election_name, String state, Date date, String constituency, String candidate_name,
			String party_name, long votes) {
		super();
		this.election_name = election_name;
		this.state = state;
		this.date = date;
		this.constituency = constituency;
		this.candidate_name = candidate_name;
		this.party_name = party_name;
		this.votes = votes;
	}
	public int getResult_id() {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
