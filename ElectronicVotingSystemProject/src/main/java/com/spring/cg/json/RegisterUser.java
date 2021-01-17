package com.spring.cg.json;

import java.sql.Date;


public class RegisterUser {

private int application_id;
private String name;
private Date dob;
private String emailId;
private String password;
private String gender;
private long mobile_number;
private String address;
private String district;


public RegisterUser() {
	super();
}


public RegisterUser(int application_id, String name, Date dob, String emailId,String password, String gender, long mobile_number,
String address, String district) {
super();
this.application_id = application_id;
this.name = name;
this.dob = dob;
this.emailId = emailId;
this.password =password;
this.gender = gender;
this.mobile_number = mobile_number;
this.address = address;
this.district = district;

}


public RegisterUser(String name, Date dob, String emailId,String password, String gender, long mobile_number, String address,
		String district) {
	super();
	this.name = name;
	this.dob = dob;
	this.emailId = emailId;
	this.password=password;
	this.gender = gender;
	this.mobile_number = mobile_number;
	this.address = address;
	this.district = district;
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


@Override
public String toString() {
	return "RegisterUser [application_id=" + application_id + ", name=" + name + ", dob=" + dob + ", emailId=" + emailId
			+ ", password=" + password + ", gender=" + gender + ", mobile_number=" + mobile_number + ", address="
			+ address + ", district=" + district + "]";
}


public void setDistrict(String district) {
	this.district = district;
}




}
