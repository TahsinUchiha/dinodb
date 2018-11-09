package com.infosys.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transaction;

import com.infosys.persistence.domain.Users;
import com.infosys.util.JSONUtil;

//	import com.qa.persistence.domain.Account;
//	import com.qa.persistence.domain.Transaction;
//	import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class DinosaurMapRepository implements DinosaurRepository {

	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Users> accountMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public DinosaurMapRepository() {
		this.accountMap = new HashMap<Long, Users>();
		ID = INITIAL_COUNT;
//		initAccountMap();
	}

	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		ID++;
		Users newAccount = util.getObjectForJSON(account, Users.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	public String updateAccount(Long id, String accountToUpdate) {
		Users newAccount = util.getObjectForJSON(accountToUpdate, Users.class);
		accountMap.put(id, newAccount);
		return accountToUpdate;
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	// private void initAccountMap() {
	//// Transaction transaction = new Transaction("sample");
	//// transaction.setId(1L);
	//// List<Transaction> transactions = new ArrayList<>();
	//// transactions.add(transaction);
	//// Users account = new Users("Joe", "Bloggs", "1234", transactions);
	//// accountMap.put(1L, account);
	// }

}
