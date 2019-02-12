package com.rats.forum.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rats.forum.entity.User;
import com.rats.forum.service.UserService;

@RestController
@RequestMapping("/u")
public class UserRestController {
	private UserService userService;

	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllusers();
	}

	@GetMapping("/find-user/{username}")
	public List<User> findUsersByUsername(@PathVariable String username) {
		List<User> users = userService.findUsersByUsername(username);
		if (users == null) {
			throw new RuntimeException("can not find user with username - " + username);
		}
		return users;
	}

	@PostMapping("/create-user")
	public User createUser(@RequestBody User theUser) {
		theUser.setId(0);
		userService.saveUser(theUser);
		return theUser;
	}

	@PutMapping("/update-user")
	public User updateUser(@RequestBody User theUser) {
		userService.saveUser(theUser);
		return theUser;
	}
	
	@DeleteMapping("/del/{userId}")
	public String deleteUserById(@PathVariable int userId) {
		User temporaryUser = userService.findUsersById(userId);
		if(temporaryUser==null) {
			throw new RuntimeException("user not found");
		}
		userService.deleteUserById(userId);
		return "deleted user with id" + userId;
	}
}
