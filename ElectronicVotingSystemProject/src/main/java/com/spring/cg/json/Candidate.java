package com.spring.cg.json;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.cg.json.Party;

import io.swagger.annotations.ApiModelProperty;



public class Candidate {
	
	
	@Min(value = 1)
	private Integer candidateId;
	
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Candidate Name")
	@Size(min =1, max = 10)
	private String candidateName;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String address;
	
	@NotNull
	@Min(value = 25)
	private Integer age;
	
    @NotNull
    @Pattern(regexp="(^$|[0-9]{10})")
	private String contactNumber;
    
    @Pattern(regexp="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$")  
    private String email;
    
	private Party party;
	
	/*
	 *  ----------------------------------------- CONSTRUCTORS FOR CLASS Candidate -------------------------------------------------------------------------
     **/
	
	public Candidate() {}

	public Candidate(Integer candidateId, String candidateName, String address, Integer age, String contactNumber, String email, Party party) {
		super();
		this.email=email;
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.party=party;
	}

	public Candidate(Integer candidateId, String candidateName, String address, Integer age, String contactNumber, String email) {
		super();
		this.email= email;
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
	}
	
	public Candidate(String candidateName, String address,  Integer age, String contactNumber, String email) {
		super();
		this.candidateName = candidateName;
		this.address = address;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
	}

	/*
     * ------------------------------------------------------- GETTER AND SETTER FOR ABOVE VARIABLES ------------------------------------------------------------------
     **/
	
	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
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

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 *  ---------------------------------------------------------- ToString METHOD FOR ABOVE VARIABLES --------------------------------------------------------------------
     **/
	
	@Override
	public String toString() {
		return "[candidate_id = " + candidateId + ", candidateName = " + candidateName + ", address = "
				+ address + ", age = " + age + ", contactNumber = " + contactNumber  + ", email = " + email + ", party_name = " +
				party.getPartyName() +"]\n";
	}
	
}
