package com.infosys.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.infosys.persistence.repository.DinosaurRepository;

public class DinosaurServiceImpl implements DinosaurService {

	@Inject
	private DinosaurRepository repo;

	public String getAllDinosaurs() {
		return repo.getAllDinosaurs();
	}


	public String createDinosaur(String dinosaur) {
		return repo.createDinosaur(dinosaur);
	}


	public String updateDinosaur(Long dinosaurid, String dinosaurToUpdate) {
		return repo.updateDinosaur(dinosaurid, dinosaurToUpdate);
	}


	public String deleteDinosaur(Long dinosaurid) {
		return repo.deleteDinosaur(dinosaurid);

	}


}
