package com.example.invoice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Caisse.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Caisse_ {

	
	/**
	 * @see com.example.invoice.model.Caisse#totalAchats
	 **/
	public static volatile SingularAttribute<Caisse, BigDecimal> totalAchats;
	
	/**
	 * @see com.example.invoice.model.Caisse#totalVentes
	 **/
	public static volatile SingularAttribute<Caisse, BigDecimal> totalVentes;
	
	/**
	 * @see com.example.invoice.model.Caisse#difference
	 **/
	public static volatile SingularAttribute<Caisse, BigDecimal> difference;
	
	/**
	 * @see com.example.invoice.model.Caisse#id
	 **/
	public static volatile SingularAttribute<Caisse, Long> id;
	
	/**
	 * @see com.example.invoice.model.Caisse#soldeDeCaisse
	 **/
	public static volatile SingularAttribute<Caisse, BigDecimal> soldeDeCaisse;
	
	/**
	 * @see com.example.invoice.model.Caisse
	 **/
	public static volatile EntityType<Caisse> class_;
	
	/**
	 * @see com.example.invoice.model.Caisse#totalDepenses
	 **/
	public static volatile SingularAttribute<Caisse, BigDecimal> totalDepenses;

	public static final String TOTAL_ACHATS = "totalAchats";
	public static final String TOTAL_VENTES = "totalVentes";
	public static final String DIFFERENCE = "difference";
	public static final String ID = "id";
	public static final String SOLDE_DE_CAISSE = "soldeDeCaisse";
	public static final String TOTAL_DEPENSES = "totalDepenses";

}

