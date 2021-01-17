package com.spring.cg.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="voter_request")
public class VoterRequestEntity {

	@Id
	@GeneratedValue
	@Column(name="application_id")
	private Long userId;
	
	private String name;
	
	private String district;
	private String constituency;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="application_status")
	private String applicationStatus;
	
	@Column(name="contact_no")
	private Long contactNumber;
	
	@Column(name="dob")
	private Date dob;
	

	public VoterRequestEntity() {
		super();
	}

	public VoterRequestEntity(Long userId, String name, String district, String constituency, String emailId,
			String applicationStatus, Long contactNumber, Date dob) {
		super();
		this.userId = userId;
		this.name = name;
		this.district = district;
		this.constituency = constituency;
		this.emailId = emailId;
		this.applicationStatus = applicationStatus;
		this.contactNumber = contactNumber;
		this.dob = dob;
		
	}

	public VoterRequestEntity(String name, String district, String constituency, String emailId,
			String applicationStatus, Long contactNumber, Date dob) {
		super();
		this.name = name;
		this.district = district;
		this.constituency = constituency;
		this.emailId = emailId;
		this.applicationStatus = applicationStatus;
		this.contactNumber = contactNumber;
		this.dob = dob;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "VoterRequestEntity [userId=" + userId + ", name=" + name + ", district=" + district + ", constituency="
				+ constituency + ", emailId=" + emailId + ", applicationStatus=" + applicationStatus
				+ ", contactNumber=" + contactNumber + ", dob=" + dob + "]";
	}
	
	
}
