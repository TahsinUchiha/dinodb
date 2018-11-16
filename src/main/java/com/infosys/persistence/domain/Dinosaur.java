package com.infosys.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dinosaur {
	@Enumerated
	private DinoType type;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dinosaurid;
	private String dinosaurName;
	private String dinosaurNumber;
	private String givenDinoName;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Users> users;

	public Dinosaur() {

	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Dinosaur(String dinosaurName, String dinosaurNumber) {
		this.dinosaurName = dinosaurName;
		this.dinosaurNumber = dinosaurNumber;
	}

	public Long getDinosaurid() {
		return dinosaurid;
	}

	public void setDinosaurid(Long dinosaurid) {
		this.dinosaurid = dinosaurid;
	}

	public String getDinosaurName() {
		return dinosaurName;
	}

	public void setDinosaurName(String dinosaurName) {
		this.dinosaurName = dinosaurName;
	}

	public String getDinosaurNumber() {
		return dinosaurNumber;
	}

	public void setDinosaurNumber(String dinosaurNumber) {
		this.dinosaurNumber = dinosaurNumber;
	}

	public String getGivenDinoName() {
		return givenDinoName;
	}

	public void setGivenDinoName(String givenDinoName) {
		this.givenDinoName = givenDinoName;
	}

	public String giveDinosaur() {
		return "Dinosaur [DinosaurName=" + dinosaurName + ", Users =" + users + "DinosaurNumber =" + dinosaurNumber
				+ "]";
	}

}
