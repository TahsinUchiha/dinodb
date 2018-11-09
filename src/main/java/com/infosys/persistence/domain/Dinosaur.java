package com.infosys.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dinosaur {
	@Enumerated
	private DinoType type;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long dinosaurid;
	private String dinosaurName;
	private String dinosaurNumber;

	public Dinosaur() {

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

}
