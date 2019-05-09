package com.myprofile.service;

import java.util.List;
import java.util.Optional;

import com.myprofile.entity.User;

public interface UserService {
	
	User createUser(User user) throws Exception;

	List<User> findAll();

	Optional<User> findById(long theId);

	void save(User theEmployee);

	void delete(long theId);
	
}
