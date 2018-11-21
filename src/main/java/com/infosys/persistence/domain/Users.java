package com.infosys.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userID;
	@Column(length = 100)
	private String userName;
//	@Column(name = "dino_ID")
//	private Long dinosaurid;
	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String lastName;
	
	
//	
	public Users() {
		
	}
	
	public Users(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
