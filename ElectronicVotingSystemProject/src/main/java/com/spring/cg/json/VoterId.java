package com.spring.cg.json;

import java.sql.Date;

import org.springframework.lang.NonNullApi;

import io.swagger.annotations.ApiModelProperty;

public class VoterId {
	/*@ApiModelProperty(value = "Voter Appication Id")
	private Long user_id;*/
	@ApiModelProperty(value = "Voter Name")
	private String name;
	@ApiModelProperty(value = "Voter district")
	private String district;
	@ApiModelProperty(value = "Voter constituency")
	private String constituency;
	@ApiModelProperty(value = "Voter VoterId")
	private Long voter_id;
	@ApiModelProperty(value = "Voter Contact number")
	private double contact_no;
	@ApiModelProperty(value = "Voter application status")
	private String status;
	@ApiModelProperty(value = "Voter date of birth")
	private Date dob;
	@ApiModelProperty(value = "Voter email id")
	private String emailId;

	public VoterId() {
		super();
	}

	public VoterId(String name, String district, String constituency, Long voter_id, double contact_no,
			String status, Date dob, String emailId) {
		super();
		
		this.name = name;
		this.district = district;
		this.constituency = constituency;
		this.voter_id = voter_id;
		this.contact_no = contact_no;
		this.status = status;
		this.dob = dob;
		this.emailId = emailId;
	}

	public VoterId( String constituency, Long voter_id, String status) {
		super();
		
		this.constituency = constituency;
		this.voter_id = voter_id;
		this.status = status;

	}

/*	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public Long getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(Long voter_id) {
		this.voter_id = voter_id;
	}

	public double getContact_no() {
		return contact_no;
	}

	public void setContact_no(double contact_no) {
		this.contact_no = contact_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "VoterId [ name=" + name + ", district=" + district + ", constituency="
				+ constituency + ", voter_id=" + voter_id + ", contact_no=" + contact_no + ", status=" + status
				+ ", dob=" + dob + ", emailId=" + emailId + "]";
	}

}