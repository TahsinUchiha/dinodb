package com.infosys.persistence.repository;

public interface DinosaurRepository {
	String getAllDinosaurs();

	String createDinosaur(String dinosaur);

	String deleteDinosaur(Long dinosaurid);

	String updateDinosaur(Long dinosaurid, String dinosaur);

}
