package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Produit.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Produit_ {

	
	/**
	 * @see com.example.invoice.model.Produit#prixUnitaire
	 **/
	public static volatile SingularAttribute<Produit, BigDecimal> prixUnitaire;
	
	/**
	 * @see com.example.invoice.model.Produit#Description
	 **/
	public static volatile SingularAttribute<Produit, String> Description;
	
	/**
	 * @see com.example.invoice.model.Produit#id
	 **/
	public static volatile SingularAttribute<Produit, Long> id;
	
	/**
	 * @see com.example.invoice.model.Produit#designation
	 **/
	public static volatile SingularAttribute<Produit, String> designation;
	
	/**
	 * @see com.example.invoice.model.Produit
	 **/
	public static volatile EntityType<Produit> class_;
	
	/**
	 * @see com.example.invoice.model.Produit#quantite
	 **/
	public static volatile SingularAttribute<Produit, Integer> quantite;

	public static final String PRIX_UNITAIRE = "prixUnitaire";
	public static final String DESCRIPTION = "Description";
	public static final String ID = "id";
	public static final String DESIGNATION = "designation";
	public static final String QUANTITE = "quantite";

}

