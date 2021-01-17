package com.spring.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="states")
public class StateEntity {
	
	@Id
	@Column(name="state")
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public StateEntity() {
		
	}

	public StateEntity(String state) {
		super();
		this.state = state;
	}

	@Override
	public String toString() {
		return "StateEntity [state=" + state + "]";
	}
	
	

}


