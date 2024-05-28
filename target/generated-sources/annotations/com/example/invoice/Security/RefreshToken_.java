package com.example.invoice.Security;

import com.example.invoice.model.User;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;

@StaticMetamodel(RefreshToken.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class RefreshToken_ {

	
	/**
	 * @see com.example.invoice.Security.RefreshToken#expiryDate
	 **/
	public static volatile SingularAttribute<RefreshToken, Instant> expiryDate;
	
	/**
	 * @see com.example.invoice.Security.RefreshToken#id
	 **/
	public static volatile SingularAttribute<RefreshToken, Long> id;
	
	/**
	 * @see com.example.invoice.Security.RefreshToken#revoked
	 **/
	public static volatile SingularAttribute<RefreshToken, Boolean> revoked;
	
	/**
	 * @see com.example.invoice.Security.RefreshToken
	 **/
	public static volatile EntityType<RefreshToken> class_;
	
	/**
	 * @see com.example.invoice.Security.RefreshToken#user
	 **/
	public static volatile SingularAttribute<RefreshToken, User> user;
	
	/**
	 * @see com.example.invoice.Security.RefreshToken#token
	 **/
	public static volatile SingularAttribute<RefreshToken, String> token;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String ID = "id";
	public static final String REVOKED = "revoked";
	public static final String USER = "user";
	public static final String TOKEN = "token";

}

