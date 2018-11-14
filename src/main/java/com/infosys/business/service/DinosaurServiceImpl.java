package com.infosys.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.infosys.persistence.repository.DinosaurRepository;

public class DinosaurServiceImpl implements DinosaurService {

//	private static final Logger LOGGER = Logger.getLogger(DinosaurService.class);

	@Inject
	private DinosaurRepository repo;

	public String getAllDinosaurs() {
		return repo.getAllDinosaurs();
	}
	
	public String addDinosaur(String dinosaur) {
		return repo.createDinosaur(dinosaur);
	}

	public String updateDinosaur(Long dinosaurid, String dinosaur) {
		return repo.updateDinosaur(dinosaurid, dinosaur);
	}

	public String deleteDinosaur(Long dinosaurid) {
		return repo.deleteDinosaur(dinosaurid);

	}

	public void setRepo(DinosaurRepository repo) {
		this.repo = repo;
	}
}
