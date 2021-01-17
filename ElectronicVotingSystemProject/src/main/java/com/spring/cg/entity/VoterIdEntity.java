package com.spring.cg.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voter_request")
public class VoterIdEntity {

	/*@Id
	@Column(name = "application_id")

	private Long user_id;*/
	@Id
	@Column(name = "voter_id")
	@GeneratedValue
	private Long voter_id;
	@Column(name = "name")
	private String name;

	@Column(name = "district")
	private String district;

	@Column(name = "constituency")
	private String constituency;
    

	@Column(name = "contact_no")
	private double contact_no;

	@Column(name = "application_status")
	private String status;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "email_id")
	private String emailId;

	public VoterIdEntity() {
		super();
	}

	public VoterIdEntity( String name, String district, String constituency, Long voter_id,
			double contact_no, String status, Date dob, String emailId) {
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

	public VoterIdEntity( String constituency, Long voter_id, String status) {
		super();
		
		this.constituency = constituency;
		this.voter_id = voter_id;
		this.status = status;
	}

	/*public Long getUser_id() {
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
		return "VoterIdEntity [ name=" + name + ", district=" + district + ", constituency="
				+ constituency + ", voterId=" + voter_id + ", contact_no=" + contact_no + ", status=" + status + ", dob="
				+ dob + ", emailId=" + emailId + "]";
	}

}