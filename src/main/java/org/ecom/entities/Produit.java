package org.ecom.entities;

import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Produit implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	
	private String name;
	private String description;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Categorie category;
	
	public Produit() {
		super();
	}
	
	

	public Produit(String name, String description, double price,
			Categorie category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}



	public Categorie getCategory() {
		return category;
	}

	public void setCategory(Categorie category) {
		this.category = category;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

	
}
