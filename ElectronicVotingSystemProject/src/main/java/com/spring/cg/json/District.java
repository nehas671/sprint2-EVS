package com.spring.cg.json;

public class District {

	 private String district;

	public District(String district) {
		super();
		this.district = district;
	}

	public District() {
		super();
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "District [district=" + district + "]";
	}
	 
}
