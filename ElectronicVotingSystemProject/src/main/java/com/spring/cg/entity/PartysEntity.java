package com.spring.cg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="party")
public class PartysEntity
{	
	@Id
	@Column(name="party_name")
	private String party_name;
	
	@Column(name="leader")
	private String leader;
	
	@Column(name="symbol")
	private String symbol;
	
	
	/*----Party to Election Many to Many----*/
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="election_party", joinColumns = { @JoinColumn(name = "party_name") }, 
				inverseJoinColumns = { @JoinColumn(name = "election_id") })
	private Set<ElectionEntity> election=new HashSet<ElectionEntity>();
	
	
	
	/*
	 *  Party to candidate One to Many 
	 */
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY, mappedBy="party")
	private Set<CandidatesEntity> candidate;

	
	public PartysEntity() {
		super();
	}

	public PartysEntity(String party_name, String leader, String symbol,Set<ElectionEntity> election)
	{
		super();
		this.party_name = party_name;
		this.leader = leader;
		this.symbol = symbol;
		this.election=election;
	}

	public PartysEntity(String party_name, String leader, String symbol)
	{
		super();
		this.party_name = party_name;
		this.leader = leader;
		this.symbol = symbol;
	}

	public PartysEntity(String party_name, String leader, String symbol, Set<ElectionEntity> election,
			Set<CandidatesEntity> candidate)
	{
		super();
		this.party_name = party_name;
		this.leader = leader;
		this.symbol = symbol;
		this.election = election;
		this.candidate = candidate;
	}
	
	
	/*
	 * Getter and Setters*/

	public String getParty_name()
	{
		return party_name;
	}

	public void setParty_name(String party_name)
	{
		this.party_name = party_name;
	}

	public String getLeader()
	{
		return leader;
	}

	public void setLeader(String leader)
	{
		this.leader = leader;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}

	public Set<ElectionEntity> getElection()
	{
		return election;
	}

	public void setElection(Set<ElectionEntity> election)
	{
		this.election = election;
	}

	public Set<CandidatesEntity> getCandidate()
	{
		return candidate;
	}

	public void setCandidate(Set<CandidatesEntity> candidate)
	{
		this.candidate = candidate;
	}

	@Override
	public String toString()
	{
		return "PartyEntity [party_name=" + party_name + ", leader=" + leader + ", symbol=" + symbol + ", election="
				+ election + ", candidate=" + candidate + "]";
	}
}
