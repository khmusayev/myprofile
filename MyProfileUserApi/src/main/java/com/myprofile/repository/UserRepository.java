package com.myprofile.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.myprofile.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	@EntityGraph(attributePaths = {"userContact", "userJobs", "userEdus"})
	User findByUsername(String username);
}
