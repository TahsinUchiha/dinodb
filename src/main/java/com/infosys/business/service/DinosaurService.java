package com.infosys.business.service;

public interface DinosaurService {

	String getAllDinosaurs();

	String createDinosaur(String dinosaur);

	String updateDinosaur(Long dinosaurid, String dinosaurToUpdate);

	String deleteDinosaur(Long dinosaurid);

}
