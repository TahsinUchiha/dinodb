package com.infosys.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.infosys.persistence.repository.DinosaurRepository;

public class DinosaurServiceImpl implements DinosaurService {

	private static final Logger LOGGER = Logger.getLogger(DinosaurService.class);

	@Inject
	private DinosaurRepository repo;

	public String getAllAccounts() {
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		return repo.createAccount(account);
	}

	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);

	}

	public void setRepo(DinosaurRepository repo) {
		this.repo = repo;
	}
}
