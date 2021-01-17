package com.spring.cg.json;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Partys {

	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Party Name")
	private String party_name;
	
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Party Leader")
	private String leader;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Party Symbol")
	private String symbol;

	private Set<Election> elections = new HashSet<Election>();
	
	
	
	public Partys() {
		super();
	}


	public Partys(String party_name, String leader, String symbol) {
		super();
		this.party_name = party_name;
		this.leader = leader;
		this.symbol = symbol;
	}
	
	
	public Partys(@NotNull @NotBlank String party_name, @NotNull @NotBlank String leader,
			@NotNull @NotBlank String symbol, Set<Election> elections) {
		super();
		this.party_name = party_name;
		this.leader = leader;
		this.symbol = symbol;
		this.elections = elections;
	}


	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Set<Election> getElections() {
		return elections;
	}
	public void setElections(Set<Election> elections) {
		this.elections = elections;
	}
	@Override
	public String toString() {
		return "Party [party_name=" + party_name + ", leader=" + leader + ", symbol=" + symbol + ", elections="
				+ elections + "]";
	}
	
	
	
}
