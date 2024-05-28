package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(DetFacture.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class DetFacture_ {

	
	/**
	 * @see com.example.invoice.model.DetFacture#prixUnitaire
	 **/
	public static volatile SingularAttribute<DetFacture, BigDecimal> prixUnitaire;
	
	/**
	 * @see com.example.invoice.model.DetFacture#montantTotalParProduit
	 **/
	public static volatile SingularAttribute<DetFacture, BigDecimal> montantTotalParProduit;
	
	/**
	 * @see com.example.invoice.model.DetFacture#produit
	 **/
	public static volatile SingularAttribute<DetFacture, Produit> produit;
	
	/**
	 * @see com.example.invoice.model.DetFacture#facture
	 **/
	public static volatile SingularAttribute<DetFacture, EnteteFact> facture;
	
	/**
	 * @see com.example.invoice.model.DetFacture#id
	 **/
	public static volatile SingularAttribute<DetFacture, Long> id;
	
	/**
	 * @see com.example.invoice.model.DetFacture
	 **/
	public static volatile EntityType<DetFacture> class_;
	
	/**
	 * @see com.example.invoice.model.DetFacture#quantite
	 **/
	public static volatile SingularAttribute<DetFacture, Long> quantite;

	public static final String PRIX_UNITAIRE = "prixUnitaire";
	public static final String MONTANT_TOTAL_PAR_PRODUIT = "montantTotalParProduit";
	public static final String PRODUIT = "produit";
	public static final String FACTURE = "facture";
	public static final String ID = "id";
	public static final String QUANTITE = "quantite";

}

