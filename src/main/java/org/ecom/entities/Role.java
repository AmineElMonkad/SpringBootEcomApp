package org.ecom.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	private String role;
	private String description;
	
	@ManyToMany(mappedBy="roles")
	private Collection<Admin> admins;

	public Role() {
		super();
	}

	public Role(String description) {
		super();
		this.description = description;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(Collection<Admin> admins) {
		this.admins = admins;
	}
	
	
	
}
