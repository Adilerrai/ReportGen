package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(ArreteDeCaisse.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class ArreteDeCaisse_ {

	
	/**
	 * @see com.example.invoice.model.ArreteDeCaisse#totalDepense
	 **/
	public static volatile SingularAttribute<ArreteDeCaisse, BigDecimal> totalDepense;
	
	/**
	 * @see com.example.invoice.model.ArreteDeCaisse#totalAchat
	 **/
	public static volatile SingularAttribute<ArreteDeCaisse, BigDecimal> totalAchat;
	
	/**
	 * @see com.example.invoice.model.ArreteDeCaisse#totalVente
	 **/
	public static volatile SingularAttribute<ArreteDeCaisse, BigDecimal> totalVente;
	
	/**
	 * @see com.example.invoice.model.ArreteDeCaisse#totalBenefice
	 **/
	public static volatile SingularAttribute<ArreteDeCaisse, BigDecimal> totalBenefice;
	
	/**
	 * @see com.example.invoice.model.ArreteDeCaisse#id
	 **/
	public static volatile SingularAttribute<ArreteDeCaisse, Long> id;
	
	/**
	 * @see com.example.invoice.model.ArreteDeCaisse
	 **/
	public static volatile EntityType<ArreteDeCaisse> class_;

	public static final String TOTAL_DEPENSE = "totalDepense";
	public static final String TOTAL_ACHAT = "totalAchat";
	public static final String TOTAL_VENTE = "totalVente";
	public static final String TOTAL_BENEFICE = "totalBenefice";
	public static final String ID = "id";

}

