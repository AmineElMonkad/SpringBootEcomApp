package org.ecom.metier;

import java.util.List;

import org.ecom.entities.Categorie;
import org.ecom.entities.Departement;
import org.ecom.entities.Produit;

public interface IEcommerceMetier {
	
	public void addOrEditDepartement(Departement dept);
	public void addOrEditCategorie(Categorie cat);
	public void addOrEditProduit(Produit prod);
	
	public List<Departement> getDepartements();
	public List<Categorie> getCategories();
	public List<Produit> getProduits();
	
	public void removeDepartement(Long idDept);
	public void removeCategorie(Long idCat);
	public void removeProduit(Long idProd);
	
	public long getMaxDeptId();
	public long getMaxCatId();
	public long getMaxProdId();
	
	public Departement getDepartement(Long idDept);
	public Categorie getCategorie(Long idCat);
	public Produit getProduit(Long idProd);
}
