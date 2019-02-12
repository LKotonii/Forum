package com.rats.forum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rats.forum.entity.User;

@Repository
public class UserDAO {

	private EntityManager entityManager;

	@Autowired
	public UserDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public User findByUserName(String username) {
		TypedQuery<User> theQuery = entityManager
				.createQuery("from User u where u.username=" + username, User.class);
		User user = theQuery.getSingleResult();
		return user;
	}
	
	

	public List<User> findUsersByUsername(String username) {

		TypedQuery<User> theQuery = entityManager
				.createQuery("from User u where u.username like" + " '%" + username + "%'", User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}

	

	
}
