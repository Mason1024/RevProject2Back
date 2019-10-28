package org.stuff.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stuff.entities.User;
import org.stuff.services.UserService;

@Component
@RestController
public class UserController {
	


	
	@Autowired
	UserService us;
	
	// Create
	@RequestMapping(value="/users", method= RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		
		return us.createUser(user);
	}
	
	// Read
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public User login(@RequestBody User user) {
		return us.login(user.getUsername(), user.getPassword());
	}
	
	@RequestMapping(value= "/users/{ID}", method= RequestMethod.GET)
	public User getUserById(@PathVariable int ID) {
		
		return us.getUserById(ID);
	}
	
	@RequestMapping(value= "/users", method= RequestMethod.GET)
	public Set<User> getAllUsers(){
		return us.getAllUsers();
	}
	
	// Update
	
	@RequestMapping(value= "/users", method= RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return us.updateUser(user);
	}
	
	// Delete
	
	@RequestMapping(value= "/users/{id}", method= RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable int id) {
		return us.deleteUser(us.getUserById(id));
	}

}
