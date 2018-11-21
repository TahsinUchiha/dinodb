package com.infosys.business.service;

public interface DinosaurService {

	String getAllDinosaurs();

	String createDinosaur(String dinosaur);

	String deleteDinosaur(Long dinosaurid);

	String getDinosaur(Long dinosaurid);

	String updateDinosaur(Long dinosaurid, String dinosaur);

	String getAllUsers();

}
