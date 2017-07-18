package sap.amit.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sap_prod")

public class Sap_Prod implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column(name = "name")
	private String name;
	
	protected Sap_Prod() {
	}

	public Sap_Prod(String id, String name) {
		this.id = id;
		this.name = name;
		
	}

	@Override
	public String toString() {
		return String.format("Sap_prod[id='%s', name='%s']", id, name);
	}

}
