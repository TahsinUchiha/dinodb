package com.infosys.persistence.repository;

public interface DinosaurRepository {
	String getAllAccounts();

	String createAccount(String accout);

	String updateAccount(Long id, String accountToUpdate);

	String deleteAccount(Long id);

}
