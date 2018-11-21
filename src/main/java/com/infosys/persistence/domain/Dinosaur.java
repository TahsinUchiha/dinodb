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
	
	@Enumerated
	private DinoType type;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dino_ID")
	private Long dinosaurid;
	@Column(length = 100)
	private String dinosaurName;
	@JoinColumn(name = "dino_ID", referencedColumnName = "dino_ID")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Users> users;

	public Dinosaur() {

	}

	public Dinosaur(Long dinosaurid, String dinosaurName, List<Users> users, DinoType type) {
		this.dinosaurid = dinosaurid;
		this.dinosaurName = dinosaurName;
		this.users = users;
		this.type = type;
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

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
