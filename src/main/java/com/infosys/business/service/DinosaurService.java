package com.infosys.business.service;

public interface DinosaurService {
	
	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(Long id, String account);

	String deleteAccount(Long id);

}
