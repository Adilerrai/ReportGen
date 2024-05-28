package com.example.invoice.model;

import com.example.invoice.enums.Role;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ {

	
	/**
	 * @see com.example.invoice.model.User#firstname
	 **/
	public static volatile SingularAttribute<User, String> firstname;
	
	/**
	 * @see com.example.invoice.model.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see com.example.invoice.model.User#role
	 **/
	public static volatile SingularAttribute<User, Role> role;
	
	/**
	 * @see com.example.invoice.model.User#id
	 **/
	public static volatile SingularAttribute<User, Long> id;
	
	/**
	 * @see com.example.invoice.model.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.example.invoice.model.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;
	
	/**
	 * @see com.example.invoice.model.User#lastname
	 **/
	public static volatile SingularAttribute<User, String> lastname;

	public static final String FIRSTNAME = "firstname";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String LASTNAME = "lastname";

}

