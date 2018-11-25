package com.infosys.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Dinosaur {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dino_ID")
	private Long dinosaurid;
	
	@Enumerated
	private DinoType type;
	
	@Column(length = 100)
	private String dinosaurName;
	@Column(length = 100)
	private String diet;
	@Column(length = 10000)
	private String description;
//	@JoinColumn(name = "dino_ID", referencedColumnName = "dino_ID")
	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private List<Users> users;

	public Dinosaur() {

	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Dinosaur(Long dinosaurid, String dinosaurName, DinoType type, String diet, String description) {
		this.dinosaurid = dinosaurid;
		this.dinosaurName = dinosaurName;
		this.type = type;
		this.diet = diet;
		this.description = description;
	}

	public DinoType getType() {
		return type;
	}

	public void setType(DinoType type) {
		this.type = type;
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

	
}
