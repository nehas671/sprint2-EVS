package com.spring.cg.entity;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="register_user")
public class RegisterUserEntity {

	
	@Id
	@GeneratedValue
	@Column(name="application_id")
	private int application_id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password", nullable = false)
	private String password;

	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile_number")
	private long mobile_number;
	
	@Column(name="address")
	private String address;
	
	@Column(name="district")
	private String district;
	
	

	

	public RegisterUserEntity() {
		super();
	}




	public RegisterUserEntity(int application_id, String name, Date dob, String emailId,String password, String gender,
			long mobile_number, String address, String district) {
		super();
		this.application_id = application_id;
		this.name = name;
		this.dob = dob;
		this.emailId = emailId;
		this.password=password;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.address = address;
		this.district = district;
		
	}
	

	public RegisterUserEntity(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public String getName() {
		return name;
	}

	



	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}
	
	


	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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
		return "RegisterUserEntity [application_id=" + application_id + ", name=" + name + ", dob=" + dob + ", emailId="
				+ emailId + ", password=" + password + ", gender=" + gender + ", mobile_number=" + mobile_number
				+ ", address=" + address + ", district=" + district + "]";
	}

	
}

