package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Client.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Client_ {

	
	/**
	 * @see com.example.invoice.model.Client#adresse
	 **/
	public static volatile SingularAttribute<Client, String> adresse;
	
	/**
	 * @see com.example.invoice.model.Client#telephone
	 **/
	public static volatile SingularAttribute<Client, String> telephone;
	
	/**
	 * @see com.example.invoice.model.Client#enteteFacts
	 **/
	public static volatile ListAttribute<Client, EnteteFact> enteteFacts;
	
	/**
	 * @see com.example.invoice.model.Client#id
	 **/
	public static volatile SingularAttribute<Client, Long> id;
	
	/**
	 * @see com.example.invoice.model.Client
	 **/
	public static volatile EntityType<Client> class_;
	
	/**
	 * @see com.example.invoice.model.Client#nom
	 **/
	public static volatile SingularAttribute<Client, String> nom;
	
	/**
	 * @see com.example.invoice.model.Client#prenom
	 **/
	public static volatile SingularAttribute<Client, String> prenom;
	
	/**
	 * @see com.example.invoice.model.Client#email
	 **/
	public static volatile SingularAttribute<Client, String> email;

	public static final String ADRESSE = "adresse";
	public static final String TELEPHONE = "telephone";
	public static final String ENTETE_FACTS = "enteteFacts";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String EMAIL = "email";

}

