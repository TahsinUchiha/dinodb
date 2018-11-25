package com.infosys.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.infosys.persistence.domain.*;
import com.infosys.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class DinosaurDBRepository implements DinosaurRepository {

	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public String getAllDinosaurs() {
		Query query = manager.createQuery("Select a FROM Dinosaur a");
		Collection<Dinosaur> dinosaur = (Collection<Dinosaur>) query.getResultList();
		return util.getJSONForObject(dinosaur);
		// TypedQuery<Dinosaur> query = manager.createQuery("SELECT d FROM Dinosaur d",
		// Dinosaur.class);
		// return util.getJSONForObject(query.getResultList());
	}
	
	public String getAllUsers() {
		Query query1 = manager.createQuery("Select b FROM Users b");
		Collection<Users> users = (Collection<Users>) query1.getResultList();
		return util.getJSONForObject(users);
	}

	@Transactional(REQUIRED)
	public String createDinosaur(String dinosaur) {
		Dinosaur aDinosaur = util.getObjectForJSON(dinosaur, Dinosaur.class);
		manager.merge(aDinosaur);
		return "{\"message\": \"Dinosaur has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String createUsers(String users) {
		Users aUser = util.getObjectForJSON(users, Users.class);
		manager.merge(aUser);
		return "{\"message\": \"User has been sucessfully added\"}";
	}


	@Transactional(REQUIRED)
	public String updateDinosaur(Long dinosaurid, String dinosaur) {
		Dinosaur updatedDinosaur = util.getObjectForJSON(dinosaur, Dinosaur.class);
		Dinosaur dinosaurInDB = findDinosaur(dinosaurid);
		// if (dinosaurToUpdate != null) {
		// for a single a table, we can just merge.
		// dinosaurFromDB = updatedDinosaur;
		// manager.merge(dinosaurFromDB);
		dinosaurInDB.setDinosaurName(updatedDinosaur.getDinosaurName());
		dinosaurInDB.setType(updatedDinosaur.getType());
		dinosaurInDB.setDescription(updatedDinosaur.getDescription());
		dinosaurInDB.setDiet(updatedDinosaur.getDiet());
		
		

		return "{\"message\": \"Dinosaur has been  sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateUsers(Long userID, String users) {
		Users updatedUser = util.getObjectForJSON(users, Users.class);
		Users usersInDB = findUsers(userID);
		usersInDB.setUserName(updatedUser.getUserName());
		usersInDB.setFirstName(updatedUser.getFirstName());
		usersInDB.setLastName(updatedUser.getLastName());


		return "{\"message\": \"User has been  sucessfully updated\"}";
	}
	
	private Users findUsers(Long userID) {
		return manager.find(Users.class, userID);
	}
	
	@Transactional(REQUIRED)
	public String deleteDinosaur(Long dinosaurid) {
		Dinosaur dinosaurInDB = findDinosaur(dinosaurid);
		if (dinosaurInDB != null) {
			manager.remove(dinosaurInDB);
		}
		return "{\"message\": \"Dinosaur sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteUsers(Long userID) {
		Users usersInDB = findUsers(userID);
		if (usersInDB != null) {
			manager.remove(usersInDB);
		}
		return "{\"message\": \"Dinosaur sucessfully deleted\"}";
	}
	
	private Dinosaur findDinosaur(Long dinosaurid) {
		return manager.find(Dinosaur.class, dinosaurid);
	}

	public String getDinosaur(Long dinosaurid) {
		Dinosaur aDinosaur = manager.find(Dinosaur.class, dinosaurid);
		return util.getJSONForObject(aDinosaur);
	}
	
	public String getUsers(Long userID) {
		Users aUser = manager.find(Users.class, userID);
		return util.getJSONForObject(aUser);
	}

	// public void setManager(EntityManager manager) {
	// this.manager = manager;
	// }
	//
	// public void setUtil(JSONUtil util) {
	// this.util = util;
	// }

}
