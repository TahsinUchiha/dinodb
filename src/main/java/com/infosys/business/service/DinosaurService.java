package com.infosys.business.service;

public interface DinosaurService {

	String getAllDinosaurs();

	String createDinosaur(String dinosaur);

	String deleteDinosaur(Long dinosaurid);

	String getDinosaur(Long dinosaurid);

	String updateDinosaur(Long dinosaurid, String dinosaur);

	String getAllUsers();
	
	String createUsers(String users);

	String deleteUsers(Long userID);

	String getUsers(Long userID);

	String updateUsers(Long userID, String users);

}
