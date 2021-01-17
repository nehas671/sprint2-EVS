package com.spring.cg.json;

import java.sql.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class VoterRequest {

	
	@ApiModelProperty(value="User Id Of Voter")
	private Long userId;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Voter Request Name")
	private String name;
	
	@NotNull
	@NotBlank
	private String emailId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Voter Request District")
	private String district;
	
	@NotNull
	@NotBlank
	@ApiModelProperty(value="Voter Request Constituency")
	private String constituency;
	
	@ApiModelProperty(value="Voter Request Application Status")
	private String applicationStatus;
	
	
	@ApiModelProperty(value="Voter Request Contact Number")
	private Long contactNumber;
	
	
	
	
	public VoterRequest() {
		super();
	}


	public VoterRequest( Long userId, String name, String emailId, Date dob,
			 String district, String constituency, String applicationStatus,Long contactNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.dob = dob;
		this.district = district;
		this.constituency = constituency;
		this.applicationStatus = applicationStatus;
		this.contactNumber = contactNumber;
	}
	
	
	public VoterRequest(String name, String emailId, Date dob,
			 String district,  String constituency, String applicationStatus, Long contactNumber) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.dob = dob;
		this.district = district;
		this.constituency = constituency;
		this.applicationStatus = applicationStatus;
		this.contactNumber = contactNumber;
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


	


	@Override
	public String toString() {
		return "VoterRequest [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", dob=" + dob
				+ ", district=" + district + ", constituency=" + constituency + ", applicationStatus="
				+ applicationStatus + ", contactNumber=" + contactNumber + "]";
	}
	
	
}
