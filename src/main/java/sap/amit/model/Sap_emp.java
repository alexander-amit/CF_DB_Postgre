package sap.amit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sap_emp")
public class Sap_emp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "team")
	private String team;

	protected Sap_emp() {
	}

	public Sap_emp(String id, String name, String team) {
		this.id = id;
		this.name = name;
		this.team = team;
	}

	@Override
	public String toString() {
		return String.format("Sap_emp[name='%s', team='%s']", name, team);
	}

}
