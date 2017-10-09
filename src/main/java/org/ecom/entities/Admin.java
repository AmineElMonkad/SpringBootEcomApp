package org.ecom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Admin implements Serializable {
	
	@Id
	private String username;
	private String password;
	private String email;
	
	@ManyToMany
	@JoinTable(
			name="admins_roles",
			joinColumns = @JoinColumn(name="username"),
			inverseJoinColumns = @JoinColumn(name="role")
			)
	private Collection<Role> roles;
	
	public Admin() {
		super();
	}
	
	public Admin(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
}
