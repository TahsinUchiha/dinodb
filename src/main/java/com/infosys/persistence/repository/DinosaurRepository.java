package com.infosys.persistence.repository;

import java.util.List;

public interface DinosaurRepository {

	String getAllDinosaurs();

	String createDinosaur(String dinosaur);

	String deleteDinosaur(Long dinosaurid);
	
	String getDinosaur(Long dinosaurid);

	String updateDinosaur(Long dinosaurid, String dinosaur);

}
