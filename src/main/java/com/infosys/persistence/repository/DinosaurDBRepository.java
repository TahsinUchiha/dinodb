package com.infosys.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.infosys.persistence.domain.*;
import com.infosys.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class DinosaurDBRepository implements DinosaurRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllDinosaurs() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Dinosaur> dinosaur = (Collection<Dinosaur>) query.getResultList();
		return util.getJSONForObject(dinosaur);
	}

	@Transactional(REQUIRED)
	public String createDinosaur(String dinosaur) {
		Dinosaur aDinosaur = util.getObjectForJSON(dinosaur, Dinosaur.class);
		manager.persist(aDinosaur);
		return "{\"message\": \"Dinosaur has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateDinosaur(Long dinosaurid, String DinosaurToUpdate) {
		Dinosaur updatedDinosaur = util.getObjectForJSON(DinosaurToUpdate, Dinosaur.class);
		Dinosaur dinosaurFromDB = findDinosaur(dinosaurid);
		if (DinosaurToUpdate != null) {
			dinosaurFromDB = updatedDinosaur;
			manager.merge(dinosaurFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String getDinosaur(Long dinosaurid) {
		Dinosaur dinosaurInDB = findDinosaur(dinosaurid);
		 return util.getJSONForObject(dinosaurInDB);
		
	}


	@Transactional(REQUIRED)
	public String deleteDinosaur(Long dinosaurid) {
		Dinosaur dinosaurInDB = findDinosaur(dinosaurid);
		if (dinosaurInDB != null) {
			manager.remove(dinosaurInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	private Dinosaur findDinosaur(Long dinosaurid) {
		return manager.find(Dinosaur.class, dinosaurid);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
