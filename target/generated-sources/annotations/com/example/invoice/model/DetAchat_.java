package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DetAchat.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class DetAchat_ {

	
	/**
	 * @see com.example.invoice.model.DetAchat#prixUnitaire
	 **/
	public static volatile SingularAttribute<DetAchat, Double> prixUnitaire;
	
	/**
	 * @see com.example.invoice.model.DetAchat#produit
	 **/
	public static volatile SingularAttribute<DetAchat, Produit> produit;
	
	/**
	 * @see com.example.invoice.model.DetAchat#quantiteAchete
	 **/
	public static volatile SingularAttribute<DetAchat, Integer> quantiteAchete;
	
	/**
	 * @see com.example.invoice.model.DetAchat#id
	 **/
	public static volatile SingularAttribute<DetAchat, Long> id;
	
	/**
	 * @see com.example.invoice.model.DetAchat#achat
	 **/
	public static volatile SingularAttribute<DetAchat, Achat> achat;
	
	/**
	 * @see com.example.invoice.model.DetAchat
	 **/
	public static volatile EntityType<DetAchat> class_;

	public static final String PRIX_UNITAIRE = "prixUnitaire";
	public static final String PRODUIT = "produit";
	public static final String QUANTITE_ACHETE = "quantiteAchete";
	public static final String ID = "id";
	public static final String ACHAT = "achat";

}

