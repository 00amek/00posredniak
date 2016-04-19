package com.user.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.user.models.User;
import com.user.models.User_entity;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService {

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName="user")
	private EntityManager em;
	
	public void AddUser(User_entity u){
		em.persist(u);
	}
}
