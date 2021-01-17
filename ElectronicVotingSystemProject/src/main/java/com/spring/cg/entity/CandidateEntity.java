package com.spring.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="candidate")
public class CandidateEntity {
	
	@Id
	@GeneratedValue
	@Column(name="candidate_id")
	private Integer candidateId;

	@Column(name="candidate_name")
	private String candidateName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="email")
	private String email;
	
	
	/*
	 *  ------------------------------------------------ CREATING ManyToOne RELATION WITH PARTY TABLE -------------------------------------------------------------------
     **/
	
	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="party_name")
	private PartyEntity party;
	
	/*
     * ------------------------------------------------- CONSTRUCTOR FOR CLASS CandidateEntity --------------------------------------------------------------------------- 
     **/
	
	public CandidateEntity() {}
	
	public CandidateEntity(String candidateName,String address, Integer age, String contactNumber, String email, PartyEntity party) {
		super();
		this.email=email;
		this.candidateName=candidateName;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.party = party;
	}
	

	public CandidateEntity(Integer candidateId, String candidateName, String address, Integer age, String contactNumber, String email, PartyEntity party) {
		super();
		this.email =email;
		this.candidateId= candidateId;
		this.candidateName = candidateName;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.party = party;
	}
	
	
	

	public CandidateEntity(String candidateName, String address, Integer age, String contactNumber, String email) {
		super();
		this.candidateName = candidateName;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
	}
   
	/*
	 *  ----------------------------------------------------- GETTER AND SETTER FOR ABOVE VARIABLES -------------------------------------------------------------------------
     **/
	
	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public PartyEntity getParty() {
		return party;
	}

	public void setParty(PartyEntity party) {
		this.party = party;
	}

    /*
     * ------------------------------------------------------- ToString METHOD FOR ABOVE VARIABLES ---------------------------------------------------------------------------
     **/
	
	@Override
	public String toString() {
		return "CandidateEntity [candidate_id=" + candidateId + ", candidateName=" + candidateName + ", address=" + address + ", age="
				+ age + ", contactNumber=" + contactNumber + ", email=" + email + ", party_name=" + party.getPartyName() + "]";
	}
	
	
}
