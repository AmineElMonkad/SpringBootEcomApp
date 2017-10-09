package org.ecom.web;


import java.util.List;





import org.ecom.entities.Admin;
import org.ecom.entities.Categorie;
import org.ecom.entities.Departement;
import org.ecom.entities.Produit;
import org.ecom.metier.IAdminMetier;
import org.ecom.metier.IEcommerceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/ecommerce")
public class EcommerceController {
	
	@Autowired
	private IEcommerceMetier ecommerceMetier;
	
	@Autowired
	private IAdminMetier adminMetier;
	
	
	
	@RequestMapping(value="/home")
	public String Home(Model model) {
		
		model.addAttribute("countDept", ecommerceMetier.getMaxDeptId());
		model.addAttribute("countCat", ecommerceMetier.getMaxCatId());
		model.addAttribute("countProd", ecommerceMetier.getMaxProdId());
		model.addAttribute("countUsers", adminMetier.getMaxAdmin());
		
		return "home";
	}
	
	@RequestMapping(value = "/showdepts")
	public String Departement(Model model) {
		
		List<Departement> depts = ecommerceMetier.getDepartements();
		model.addAttribute("depts", depts);
		return "showdepts";
		
	}
	
	@RequestMapping(value = "/deleteDept/{idDepartement}", method = RequestMethod.GET)
	public String removeDepartement(Model model, @PathVariable String idDepartement) {
		
		ecommerceMetier.removeDepartement(Long.parseLong(idDepartement));
		
		return "redirect:/ecommerce/showdepts";
	}
	
	@RequestMapping(value = "/addDept", method = RequestMethod.GET)
	public String goAddDepartement(Model model) {
		model.addAttribute("maxDeptId", ecommerceMetier.getMaxDeptId()+1);
		return "addDept";
	}
	
	@RequestMapping(value = "/addDept", method = RequestMethod.POST)
	public String addDepartement(Model model, String txtNameDept, String txtDescDept) {
		ecommerceMetier.addOrEditDepartement(new Departement(txtNameDept, txtDescDept));
		return "redirect:/ecommerce/showdepts";
	}
	
	@RequestMapping(value = "/editDept/{idDepartement}", method = RequestMethod.GET)
	public String goEditDepartement(Model model, @PathVariable String idDepartement) {
		
		Departement dept = ecommerceMetier.getDepartement(Long.parseLong(idDepartement));
		model.addAttribute("dept",dept);
		
		return "editDept";
	}
	
	@RequestMapping(value = "/editDept", method = RequestMethod.POST)
	public String editDepartement(Model model,String txtIdDept, String txtNameDept, String txtDescDept) {
		
		Departement dept = ecommerceMetier.getDepartement(Long.parseLong(txtIdDept));
		dept.setName(txtNameDept);
		dept.setDescription(txtDescDept);
		ecommerceMetier.addOrEditDepartement(dept);
		
		return "redirect:/ecommerce/showdepts";
	}
	
	@RequestMapping(value = "/detailsDept/{idDepartement}", method = RequestMethod.GET)
	public String detailsDepartement(Model model, @PathVariable String idDepartement) {
		
		Departement dept = ecommerceMetier.getDepartement(Long.parseLong(idDepartement));
		model.addAttribute("cats", dept.getCategories());
		model.addAttribute("nameDept", dept.getName());
		return "detailsDept";
	}
	
	@RequestMapping(value = "/showcats")
	public String Categorie(Model model) {
		
		List<Categorie> cats = ecommerceMetier.getCategories();
		model.addAttribute("cats", cats);
		return "showcats";
		
	}
	
	@RequestMapping(value = "/deleteCat/{idCategorie}", method = RequestMethod.GET)
	public String removeCategorie(Model model, @PathVariable String idCategorie) {
		
		ecommerceMetier.removeCategorie(Long.parseLong(idCategorie));
		
		return "redirect:/ecommerce/showcats";
	}
	
	@RequestMapping(value = "/addCat", method = RequestMethod.GET)
	public String goAddCategorie(Model model) {
		model.addAttribute("maxCatId", ecommerceMetier.getMaxCatId()+1);
		model.addAttribute("depts", ecommerceMetier.getDepartements());
		return "addCat";
	}
	
	@RequestMapping(value = "/addCat", method = RequestMethod.POST)
	public String addCategorie(Model model, String txtNameCat, String txtDescCat, String deptCat) {
		ecommerceMetier.addOrEditCategorie(new Categorie(txtNameCat, txtDescCat, ecommerceMetier.getDepartement(Long.parseLong(deptCat))));
		return "redirect:/ecommerce/showcats";
	}
	
	@RequestMapping(value = "/editCat/{idCategorie}", method = RequestMethod.GET)
	public String goEditCategorie(Model model, @PathVariable String idCategorie) {
		
		Categorie cat = ecommerceMetier.getCategorie(Long.parseLong(idCategorie));
		model.addAttribute("cat",cat);
		model.addAttribute("depts", ecommerceMetier.getDepartements());
		return "editCat";
	}
	
	@RequestMapping(value = "/editCat", method = RequestMethod.POST)
	public String editCategorie(Model model,String txtIdCat, String txtNameCat, String txtDescCat, String deptCat) {
		
		Categorie cat = ecommerceMetier.getCategorie(Long.parseLong(txtIdCat));
		cat.setName(txtNameCat);
		cat.setDescription(txtDescCat);
		cat.setDepartement(ecommerceMetier.getDepartement(Long.parseLong(deptCat)));
		ecommerceMetier.addOrEditCategorie(cat);
		
		return "redirect:/ecommerce/showcats";
	}
	
	@RequestMapping(value = "/detailsCat/{idCategorie}", method = RequestMethod.GET)
	public String detailsCatégorie(Model model, @PathVariable String idCategorie) {
		
		Categorie cat = ecommerceMetier.getCategorie(Long.parseLong(idCategorie));
		model.addAttribute("prods", cat.getProduits());
		model.addAttribute("nameCat", cat.getName());
		return "detailsCat";
	}
	
	@RequestMapping(value = "/showprods")
	public String Produit(Model model) {
		
		List<Produit> prods = ecommerceMetier.getProduits();
		model.addAttribute("prods", prods);
		return "showprods";
		
	}
	
	@RequestMapping(value = "/deleteProd/{idProduit}", method = RequestMethod.GET)
	public String removeProduit(Model model, @PathVariable String idProduit) {
		
		ecommerceMetier.removeProduit(Long.parseLong(idProduit));
		
		return "redirect:/ecommerce/showprods";
	}
	
	@RequestMapping(value = "/addProd", method = RequestMethod.GET)
	public String goAddProduit(Model model) {
		model.addAttribute("maxProdId", ecommerceMetier.getMaxProdId()+1);
		model.addAttribute("cats", ecommerceMetier.getCategories());
		return "addProd";
	}
	
	@RequestMapping(value = "/addProd", method = RequestMethod.POST)
	public String addProduit(Model model, String txtNameProd, String txtDescProd, String txtPriceProd, String catProd) {
		ecommerceMetier.addOrEditProduit(new Produit(txtNameProd, txtDescProd, Double.parseDouble(txtPriceProd), ecommerceMetier.getCategorie(Long.parseLong(catProd))));;
		return "redirect:/ecommerce/showprods";
	}
	
	@RequestMapping(value = "/editProd/{idProduit}", method = RequestMethod.GET)
	public String goEditProduit(Model model, @PathVariable String idProduit) {
		
		Produit prod = ecommerceMetier.getProduit(Long.parseLong(idProduit));
		model.addAttribute("prod",prod);
		model.addAttribute("cats", ecommerceMetier.getCategories());
		return "editProd";
	}
	
	@RequestMapping(value = "/editProd", method = RequestMethod.POST)
	public String editProduit(Model model, String txtIdProd, String txtNameProd, String txtDescProd, String txtPriceProd, String catProd) {
		
		Produit prod = ecommerceMetier.getProduit(Long.parseLong(txtIdProd));
		prod.setName(txtNameProd);
		prod.setDescription(txtDescProd);
		prod.setPrice(Double.parseDouble(txtPriceProd));
		prod.setCategory(ecommerceMetier.getCategorie(Long.parseLong(catProd)));
		ecommerceMetier.addOrEditProduit(prod);
		
		return "redirect:/ecommerce/showprods";
	}
	
	
	

}
