package com.infosys.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.infosys.persistence.repository.DinosaurRepository;

public class DinosaurServiceImpl implements DinosaurService {

	private static final Logger LOGGER = Logger.getLogger(DinosaurService.class);

	@Inject
	private DinosaurRepository repo;

	public String getAllDinosaurs() {
		LOGGER.info("In DinosaurServiceImpl getAllDinosaurs ");
		return repo.getAllDinosaurs();
	}
	@Override
	public String createDinosaur(String dinosaur) {
		return repo.createDinosaur(dinosaur);
	}
	@Override
	public String updateDinosaur(Long dinosaurid, String dinosaur) {
		return repo.updateDinosaur(dinosaurid, dinosaur);
	}
	@Override
	public String deleteDinosaur(Long dinosaurid) {
		return repo.deleteDinosaur(dinosaurid);

	}
	public void setRepo(DinosaurRepository repo) {
		this.repo = repo;
	}
	
}
