package com.spring.cg.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="login" ,schema = "public")
public class UserLoginEntity {

	
		@Id
		@GeneratedValue
		
		@Column(name="email" , nullable = false, unique = true)
		private String emailId;
				
		
		@Column(name="password", nullable = false)
		private String password;
		
		
		public UserLoginEntity() {
			super();
		}

		public UserLoginEntity(String emailId,String password) {
			super();
			this.emailId = emailId;
			this.password = password;
			
		}

				
		
		

		
		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "UserLoginEntity [emailId=" + emailId + ", password=" + password + "]";
		}

		
		
		

		
}
