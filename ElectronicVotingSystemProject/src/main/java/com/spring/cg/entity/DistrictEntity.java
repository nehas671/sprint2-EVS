package com.spring.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="districts")
public class DistrictEntity {

	@Id
	@GeneratedValue
	private String district;
	
	

	public DistrictEntity() {
		super();
	}

	public DistrictEntity(String district) {
		super();
		this.district = district;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "DistrictEntity [district=" + district + "]";
	}
	
	
	
}
