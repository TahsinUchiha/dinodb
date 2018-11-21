package com.infosys.business.service;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.infosys.persistence.domain.Dinosaur;
import com.infosys.persistence.domain.Users;
import com.infosys.persistence.repository.DinosaurDBRepository;

public class DinosaurServiceImpl implements DinosaurService{

	@Inject
	private DinosaurDBRepository service;

	public String getAllDinosaurs() {
		return service.getAllDinosaurs();
	}

	public String getAllUsers() {
		return service.getAllUsers();
	}

	public String createDinosaur(String dinosaur) {
		return service.createDinosaur(dinosaur);
	}

	public String createUsers(String users) {
		return service.createUsers(users);
	}

	public String updateDinosaur(Long dinosaurid, String dinosaur) {
		return service.updateDinosaur(dinosaurid, dinosaur);
	}

	public String updateUsers(Long userID, String users) {
		return service.updateUsers(userID, users);
	}

	public String deleteDinosaur(Long dinosaurid) {
		return service.deleteDinosaur(dinosaurid);
	}

	public String deleteUsers(Long userID) {
		return service.deleteUsers(userID);
	}

	public String getDinosaur(Long dinosaurid) {
		return service.getDinosaur(dinosaurid);
	}

	public String getUsers(Long userID) {
		return service.getUsers(userID);
	}
	
	public void setRepo(DinosaurDBRepository persist) {
		this.service = persist;
	}

}
