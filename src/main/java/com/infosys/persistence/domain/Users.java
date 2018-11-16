package com.infosys.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Users {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userid;
	private String userName;
	private Long dinosaurid;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getDinosaurid() {
		return dinosaurid;
	}
	public void setDinosaurid(Long dinosaurid) {
		this.dinosaurid = dinosaurid;
	}
	


}
