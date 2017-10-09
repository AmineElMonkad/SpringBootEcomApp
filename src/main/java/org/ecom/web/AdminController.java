package org.ecom.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.ecom.entities.Departement;
import org.ecom.entities.Admin;
import org.ecom.entities.Role;
import org.ecom.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private IAdminMetier adminMetier;

	@RequestMapping(value = "/showadmins")
	public String Admins(Model model) {
		
		List<Admin> admins = adminMetier.getAdmins();
		model.addAttribute("admins", admins);
		return "showadmins";
		
	}
	
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	public String goAddAdmin(Model model) {
		model.addAttribute("maxAdminId", adminMetier.getMaxAdmin() + 1);
		return "addAdmin";
	}
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(Model model, String txtEmailAdmin, String txtPasswordAdmin ,String txtUsernameAdmin) {
		Admin admin = new Admin(txtUsernameAdmin, txtPasswordAdmin, txtEmailAdmin);
		Role role = adminMetier.getRole("SOUS_ADMIN");
		
	    List<Role> roles = new ArrayList<Role>();
	    roles.add(role);
		admin.setRoles(roles);
		adminMetier.AddOrEditUser(admin);
		
		return "redirect:/admin/showadmins";
	}
	
	@RequestMapping(value = "/deleteAdmin/{username}", method = RequestMethod.GET)
	public String removeAdmin(Model model, @PathVariable String username) {
		
		Admin a = adminMetier.getAdmin(username);
		adminMetier.removeAdmin(a);
		
		return "redirect:/admin/showadmins";
	}
	
	@RequestMapping(value = "/editAdmin/{username}", method = RequestMethod.GET)
	public String goEditAdmin(Model model, @PathVariable String username) {
		
		Admin a = adminMetier.getAdmin(username);
		model.addAttribute("admin",a);
		
		return "editAdmin";
	}
	
	@RequestMapping(value = "/editAdmin", method = RequestMethod.POST)
	public String editAdmin(Model model,String txtUsername, String txtPassword, String txtEmail) {
		
		Admin ad = adminMetier.getAdmin(txtUsername);
		ad.setEmail(txtEmail);
		ad.setPassword(txtPassword);
		adminMetier.AddOrEditUser(ad);
		
		return "redirect:/admin/showadmins";
	}
	
	@RequestMapping(value = "/detailsAdmin/{username}", method = RequestMethod.GET)
	public String detailsAdmin(Model model, @PathVariable String username) {
		
		Admin a = adminMetier.getAdmin(username);
		model.addAttribute("admin", a);
		
		return "detailsAdmin";
	}
	
	
	
	
}
