package org.ecom;

import org.ecom.dao.CategorieRepository;
import org.ecom.dao.DepartementRepository;
import org.ecom.dao.ProduitRepository;
import org.ecom.entities.Categorie;
import org.ecom.entities.Departement;
import org.ecom.entities.Produit;
import org.ecom.metier.IEcommerceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ECommerceProjectApplication implements CommandLineRunner{

	@Autowired
	IEcommerceMetier ecommerceMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceProjectApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
