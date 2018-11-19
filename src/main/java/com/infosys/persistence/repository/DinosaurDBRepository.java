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
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	@Inject
	private JSONUtil util;


	public String getAllDinosaurs() {
		Query query = manager.createQuery("Select a FROM Dinosaur a");
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
	public String updateDinosaur(Long dinosaurid, String dinosaurToUpdate) {
		Dinosaur updatedDinosaur = util.getObjectForJSON(dinosaurToUpdate, Dinosaur.class);
		Dinosaur dinosaurFromDB = findDinosaur(dinosaurid);
		if (dinosaurToUpdate != null) {
			// for a single a table, we can just merge.
			// dinosaurFromDB = updatedDinosaur;
			// manager.merge(dinosaurFromDB);
			dinosaurFromDB.setDinosaurName(updatedDinosaur.getDinosaurName());
			dinosaurFromDB.setUsers(updatedDinosaur.getUsers());

		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String getDinosaur(Long dinosaurid) {
		Dinosaur dinosaurInDB = findDinosaur(dinosaurid);
		return util.getJSONForObject(dinosaurInDB);

	}

	@Override
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

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
