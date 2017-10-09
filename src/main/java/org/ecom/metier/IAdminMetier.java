package org.ecom.metier;

import java.util.List;

import org.ecom.entities.Admin;
import org.ecom.entities.Role;

public interface IAdminMetier extends IEcommerceMetier {
	
	public void AddOrEditUser(Admin ad);
	public Admin getAdmin(String username);
	public List<Admin> getAdmins();
	public Long getMaxAdmin();
	public void removeAdmin(Admin ad);
	public Role getRole(String name);

}
