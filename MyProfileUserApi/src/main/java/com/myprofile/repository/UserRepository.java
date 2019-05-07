package com.myprofile.repository;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	User findByEmail(String email);
}
