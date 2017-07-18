package sap.amit.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sap.amit.model.Sap_emp;

public interface Sap_empRepo extends CrudRepository<Sap_emp, String> {
	
	List<Sap_emp> findById(long id);

}
