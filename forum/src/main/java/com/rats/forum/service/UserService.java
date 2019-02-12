package com.rats.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rats.forum.dao.UserDAO;
import com.rats.forum.dao.UserRepository;
import com.rats.forum.entity.User;
import com.rats.forum.user_crm.CrmUser;

@Service
public class UserService implements UserServiceInterface {

	private UserRepository userRepository;
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@Autowired
	public UserService (UserRepository theUserRepository, UserDAO theUserDAO) {
		userRepository = theUserRepository;
		userDAO = theUserDAO;
	}
	
	@Transactional
	public List<User> getAllusers(){
		return userRepository.findAll();
	}
	
	@Transactional
	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}
	
	@Transactional
	public List<User> findUsersByUsername(String username) {
		return userDAO.findUsersByUsername(username);
	}
	
	@Transactional
	public void deleteUserById(int userId) {
		userRepository.deleteById(userId);
	}
	
	@Transactional
	public  User findUsersById(int userId) {
		
		Optional<User> result = userRepository.findById(userId);
		User theUser = null;
		if(result.isPresent()) {
			theUser=result.get();
		}
		else {
			throw new RuntimeException("the user with id "+ userId + " can not be found");
		}
		return theUser;
	}

	public User findByUsername(String username) {
		return userDAO.findByUserName(username);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		 // assign user details to the user object
		user.setUsername(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		
		user.setEmail(crmUser.getEmail());

		
		 // save user in the database
		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDAO.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), null);
	}
}
