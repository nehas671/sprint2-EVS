package com.spring.cg.json;

import java.time.LocalDate;
import java.util.Date;
//import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Schedule {
private Long electionId;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Election Name")
	private String election_name;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Election State")
	private String state;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Election constituency ")
	private String constituency;
	
	
	
	@ApiModelProperty(value="Election date ")
	private LocalDate date;



	public Schedule(Long electionId, @NotNull @NotBlank String election_name, @NotNull @NotBlank String state,
			@NotNull @NotBlank String constituency, LocalDate date) {
		super();
		this.electionId = electionId;
		this.election_name = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}



	public Schedule(@NotNull @NotBlank String election_name, @NotNull @NotBlank String state,
			@NotNull @NotBlank String constituency, LocalDate date) {
		super();
		this.election_name = election_name;
		this.state = state;
		this.constituency = constituency;
		this.date = date;
	}



	public Schedule() {
		super();
	}



	public Long getElectionId() {
		return electionId;
	}



	public void setElectionId(Long electionId) {
		this.electionId = electionId;
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



	@Override
	public String toString() {
		return "Schedule [ date=" + date+ ", election_name=" + election_name + ", state=" + state
				+ ", constituency=" + constituency + ", electionId=" + electionId + "]";
	}
}
