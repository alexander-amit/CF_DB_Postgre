package sap.amit.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sap.amit.model.Sap_emp;
import sap.amit.repo.Sap_empRepo;

@RestController
public class Sap_empController {
	@Autowired
	Sap_empRepo sap_empRepo;

	@RequestMapping("/save/{id}/{name}/{team}")
	public String save(@PathVariable("id") String id, @PathVariable("name") String name,
			@PathVariable("team") String team) {
		try {
			sap_empRepo.save(new Sap_emp(id, name, team));
			return "Person data saved successfully please invoke getDetails/{id} method to get data";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error saving data";
		}
	}

	@GetMapping("/getDetails/{id}")
	public String getDetals(@PathVariable("id") String id) {
		String result;
		try {
			result = sap_empRepo.findOne(id).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error geting data";
		}
		return result;
	}

}
