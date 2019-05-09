package com.myprofile.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprofile.entity.User;
import com.myprofile.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserAPIRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		Optional<User> theUser = userService.findById((long) userId);
		
		if(!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		return theUser.get();
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		theUser.setId((long) 0);
		userService.save(theUser);
		return theUser;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		userService.save(theUser);
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		Optional<User> tempUser = userService.findById(userId);
		if(!tempUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		userService.delete(userId);
		return "Deleted user id - " + userId;
	}

}
