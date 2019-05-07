package com.myprofile.repository;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
