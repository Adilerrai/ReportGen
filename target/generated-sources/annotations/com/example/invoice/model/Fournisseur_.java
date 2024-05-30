package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Fournisseur.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Fournisseur_ {

	
	/**
	 * @see com.example.invoice.model.Fournisseur#achats
	 **/
	public static volatile ListAttribute<Fournisseur, Achat> achats;
	
	/**
	 * @see com.example.invoice.model.Fournisseur#adresse
	 **/
	public static volatile SingularAttribute<Fournisseur, String> adresse;
	
	/**
	 * @see com.example.invoice.model.Fournisseur#infoSupplementaire
	 **/
	public static volatile SingularAttribute<Fournisseur, String> infoSupplementaire;
	
	/**
	 * @see com.example.invoice.model.Fournisseur#telephone
	 **/
	public static volatile SingularAttribute<Fournisseur, String> telephone;
	
	/**
	 * @see com.example.invoice.model.Fournisseur#id
	 **/
	public static volatile SingularAttribute<Fournisseur, Long> id;
	
	/**
	 * @see com.example.invoice.model.Fournisseur
	 **/
	public static volatile EntityType<Fournisseur> class_;
	
	/**
	 * @see com.example.invoice.model.Fournisseur#nom
	 **/
	public static volatile SingularAttribute<Fournisseur, String> nom;
	
	/**
	 * @see com.example.invoice.model.Fournisseur#email
	 **/
	public static volatile SingularAttribute<Fournisseur, String> email;

	public static final String ACHATS = "achats";
	public static final String ADRESSE = "adresse";
	public static final String INFO_SUPPLEMENTAIRE = "infoSupplementaire";
	public static final String TELEPHONE = "telephone";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String EMAIL = "email";

}

