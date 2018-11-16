package com.infosys.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.transaction.Transaction;

import com.infosys.persistence.domain.Dinosaur;
import com.infosys.persistence.domain.Users;
import com.infosys.util.JSONUtil;

//	import com.qa.persistence.domain.Account;
//	import com.qa.persistence.domain.Transaction;
//	import com.qa.util.JSONUtil;

@Alternative
public class DinosaurMapRepository implements DinosaurRepository {

	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Dinosaur> dinosaurMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public DinosaurMapRepository() {
		this.dinosaurMap = new HashMap<Long, Dinosaur>();
		ID = INITIAL_COUNT;
//		initDinosaurMap();
	}

	@Override
	public String getAllDinosaurs() {
		return util.getJSONForObject(dinosaurMap.values());
	}

	@Override
	public String createDinosaur(String dinosaur) {
		ID++;
		Dinosaur newDinosaur = util.getObjectForJSON(dinosaur, Dinosaur.class);
		dinosaurMap.put(ID, newDinosaur);
		return dinosaur;
	}

	@Override
	public String updateDinosaur(Long dinosaurid, String dinosaurToUpdate) {
		Dinosaur newDinosaur = util.getObjectForJSON(dinosaurToUpdate, Dinosaur.class);
		dinosaurMap.put(dinosaurid, newDinosaur);
		return dinosaurToUpdate;
	}

	@Override
	public String deleteDinosaur(Long dinosaurid) {
		dinosaurMap.remove(dinosaurid);
		return "{\"message\": \"dinosaur sucessfully removed\"}";
	}

//	private void initDinosaurMap() {
//		// Dinosaur dinosaur = new Dinosaur("Rex", "1");
//		// dinosaurMap.put(1L, dinosaur);
//		Users users = new Users();
//		users.setDinosaurid(1L);
//		List<Users> userss = new ArrayList<>();
//		userss.add(users);
//		Dinosaur dinosaur = new Dinosaur();
//		dinosaurMap.put(1L, dinosaur);
//	}

}
