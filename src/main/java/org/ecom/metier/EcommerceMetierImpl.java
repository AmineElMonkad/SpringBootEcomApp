package org.ecom.metier;

import java.util.List;

import org.ecom.dao.CategorieRepository;
import org.ecom.dao.DepartementRepository;
import org.ecom.dao.ProduitRepository;
import org.ecom.dao.RoleRepository;
import org.ecom.dao.UsersRepository;
import org.ecom.entities.Categorie;
import org.ecom.entities.Departement;
import org.ecom.entities.Produit;
import org.ecom.entities.Admin;
import org.ecom.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EcommerceMetierImpl implements IAdminMetier{
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void addOrEditDepartement(Departement dept) {
		// TODO Auto-generated method stub
		departementRepository.save(dept);
	}

	@Override
	public void addOrEditCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		categorieRepository.save(cat);
	}

	@Override
	public void addOrEditProduit(Produit prod) {
		// TODO Auto-generated method stub
		produitRepository.save(prod);
	}

	@Override
	public List<Departement> getDepartements() {
		return departementRepository.findAll();
	}

	@Override
	public List<Categorie> getCategories() {
		return categorieRepository.findAll();
	}

	@Override
	public List<Produit> getProduits() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public void removeDepartement(Long idDept) {
		// TODO Auto-generated method stub
		departementRepository.delete(idDept);;
	}

	@Override
	public void removeCategorie(Long idCat) {
		// TODO Auto-generated method stub
		categorieRepository.delete(idCat);
	}

	@Override
	public void removeProduit(Long idProd) {
		// TODO Auto-generated method stub
		produitRepository.delete(idProd);
	}

	@Override
	public long getMaxDeptId() {
		// TODO Auto-generated method stub
		return departementRepository.count();
	}

	@Override
	public long getMaxCatId() {
		// TODO Auto-generated method stub
		return categorieRepository.count();
	}

	@Override
	public long getMaxProdId() {
		// TODO Auto-generated method stub
		return produitRepository.count();
	}

	@Override
	public Departement getDepartement(Long idDept) {
		// TODO Auto-generated method stub
		return departementRepository.findOne(idDept);
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return categorieRepository.findOne(idCat);
	}

	@Override
	public Produit getProduit(Long idProd) {
		// TODO Auto-generated method stub
		return produitRepository.findOne(idProd);
	}

	@Override
	public void AddOrEditUser(Admin ad) {
		// TODO Auto-generated method stub
		usersRepository.save(ad);
	}

	@Override
	public Admin getAdmin(String username) {
		// TODO Auto-generated method stub
		return usersRepository.findOne(username);
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Long getMaxAdmin() {
		// TODO Auto-generated method stub
		return usersRepository.count();
	}

	@Override
	public void removeAdmin(Admin ad) {
		// TODO Auto-generated method stub
		usersRepository.delete(ad);
	}

	@Override
	public Role getRole(String name) {
		
		return roleRepository.findOne(name) ;
	}
	
	

}
