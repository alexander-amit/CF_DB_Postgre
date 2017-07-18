package sap.amit.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sap.amit.model.Sap_Prod;
import sap.amit.model.Sap_emp;
import sap.amit.repo.Sap_Prod_Repo;
import sap.amit.repo.Sap_empRepo;

public class Sap_Prod_Controller {

@RestController
public class Sap_empController {
	@Autowired
	Sap_Prod_Repo sap_Prod_Repo;

	@RequestMapping("/insert/{id}/{name}")
	public String save(@PathVariable("id") String id, @PathVariable("name") String name) {
		try {
			sap_Prod_Repo.save(new Sap_Prod(id, name));
			return "Person data saved successfully please invoke getDetails/{id} method to get data";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error saving data";
		}
	}

	@GetMapping("/getprod/{id}")
	public String getDetals(@PathVariable("id") String id) {
		String result;
		try {
			result = sap_Prod_Repo.findOne(id).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error geting data";
		}
		return result;
	}

}}