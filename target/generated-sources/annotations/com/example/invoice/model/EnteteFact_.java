package com.example.invoice.model;

import com.example.invoice.enums.ModePaiement;
import com.example.invoice.enums.Status;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(EnteteFact.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class EnteteFact_ {

	
	/**
	 * @see com.example.invoice.model.EnteteFact#createdDate
	 **/
	public static volatile SingularAttribute<EnteteFact, Date> createdDate;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#detFactures
	 **/
	public static volatile ListAttribute<EnteteFact, DetFacture> detFactures;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#numeroFacture
	 **/
	public static volatile SingularAttribute<EnteteFact, Long> numeroFacture;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#dateFacture
	 **/
	public static volatile SingularAttribute<EnteteFact, Date> dateFacture;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#modePaiement
	 **/
	public static volatile SingularAttribute<EnteteFact, ModePaiement> modePaiement;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#client
	 **/
	public static volatile SingularAttribute<EnteteFact, Client> client;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#id
	 **/
	public static volatile SingularAttribute<EnteteFact, Long> id;
	
	/**
	 * @see com.example.invoice.model.EnteteFact
	 **/
	public static volatile EntityType<EnteteFact> class_;
	
	/**
	 * @see com.example.invoice.model.EnteteFact#statut
	 **/
	public static volatile SingularAttribute<EnteteFact, Status> statut;

	public static final String CREATED_DATE = "createdDate";
	public static final String DET_FACTURES = "detFactures";
	public static final String NUMERO_FACTURE = "numeroFacture";
	public static final String DATE_FACTURE = "dateFacture";
	public static final String MODE_PAIEMENT = "modePaiement";
	public static final String CLIENT = "client";
	public static final String ID = "id";
	public static final String STATUT = "statut";

}

