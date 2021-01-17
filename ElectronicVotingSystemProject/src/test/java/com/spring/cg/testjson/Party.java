package com.spring.cg.testjson;


public class Party {
	private String partyName;
	private String leader;
	private String symbol;
	
	/*
	 *  ------------------------------------------- CONSTRUCTORS FOR Party CLASS ------------------------------------------------------------------------------
	 **/
	
	public Party() {}

	public Party(String partyName, String leader, String symbol) {
		super();
		this.partyName=partyName;
		this.leader = leader;
		this.symbol = symbol;
	}

	/*
	 * --------------------------------------------- GETTER AND SETTER FOR ABOVE VARIABLES ---------------------------------------------------------------------
     **/
	
	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName= partyName;
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

	/*
	 * ------------------------------------------------ ToString METHOD FOR ABOVE VARIABLES ----------------------------------------------------------------------- 
	 **/
	
	@Override
	public String toString() {
		return "Party [partyName=" + partyName + ", leader=" + leader + ", symbol=" + symbol + "]";
	}

}

