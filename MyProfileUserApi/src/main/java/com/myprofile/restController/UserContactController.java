package com.myprofile.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprofile.entity.User;
import com.myprofile.entity.UserContact;
import com.myprofile.service.UserContactService;
import com.myprofile.service.UserService;

@RestController
@RequestMapping("/userapi/users/{userId}")
public class UserContactController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserContactService userContactService;

	@GetMapping("/contact")
	public UserContact getContact(@PathVariable int userId) {

		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		UserContact contact = userContactService.findByUserId(userId);
		return contact;
	}

	@PostMapping("/contact")
	public UserContact addUpdateContact(@PathVariable int userId, @RequestBody UserContact theContact) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}

		theContact.setId((long) 0);
		UserContact currentContact = theUser.get().getUserContact();
		if(currentContact != null) {
			theUser.get().setUserContact(null);
			currentContact.setUser(null);
			userContactService.delete(currentContact);
		}
		theUser.get().setUserContact(theContact);	
		userService.save(theUser.get());
//		userContactService.save(theContact);
		return theContact;
	}

	@DeleteMapping("/contact")
	public String deleteUser(@PathVariable int userId) {
		Optional<User> theUser = userService.findById((long) userId);

		if (!theUser.isPresent()) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		UserContact contact = userContactService.findByUserId(userId);
		if (contact == null) {
			return "No Contact to delete";
		}
		userContactService.delete(contact);
		return "Deleted Contact id - " + contact.getId();
	}

}
