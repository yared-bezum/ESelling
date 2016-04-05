package edu.mum.eselling.domain;
import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Admin extends User implements Serializable{
	private static final long serialVersionUID = -3794885616176050983L;

	public Admin() {
		super();
	}

}
