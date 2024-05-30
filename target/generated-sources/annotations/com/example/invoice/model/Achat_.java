package com.example.invoice.model;

import com.example.invoice.enums.StatusAchat;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.sql.Date;

@StaticMetamodel(Achat.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Achat_ {

	
	/**
	 * @see com.example.invoice.model.Achat#totalAchat
	 **/
	public static volatile SingularAttribute<Achat, BigDecimal> totalAchat;
	
	/**
	 * @see com.example.invoice.model.Achat#statusAchat
	 **/
	public static volatile SingularAttribute<Achat, StatusAchat> statusAchat;
	
	/**
	 * @see com.example.invoice.model.Achat#dateAchat
	 **/
	public static volatile SingularAttribute<Achat, Date> dateAchat;
	
	/**
	 * @see com.example.invoice.model.Achat#fournisseur
	 **/
	public static volatile SingularAttribute<Achat, Fournisseur> fournisseur;
	
	/**
	 * @see com.example.invoice.model.Achat#id
	 **/
	public static volatile SingularAttribute<Achat, Long> id;
	
	/**
	 * @see com.example.invoice.model.Achat
	 **/
	public static volatile EntityType<Achat> class_;
	
	/**
	 * @see com.example.invoice.model.Achat#detAchats
	 **/
	public static volatile ListAttribute<Achat, DetAchat> detAchats;

	public static final String TOTAL_ACHAT = "totalAchat";
	public static final String STATUS_ACHAT = "statusAchat";
	public static final String DATE_ACHAT = "dateAchat";
	public static final String FOURNISSEUR = "fournisseur";
	public static final String ID = "id";
	public static final String DET_ACHATS = "detAchats";

}

