package com.myprofile.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myprofile.entity.User;
import com.myprofile.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
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

	@GetMapping("/users/username/{username}")
	public User getUser(@PathVariable String username) {

		User theUser = userService.findByUsername(username);
		if(theUser == null) {
			throw new RuntimeException(String.format("User with username = %s not found.", username));
		}
		return theUser;
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
