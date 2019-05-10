package com.myprofile.repository;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.entity.UserContact;

public interface UserContactRepository extends CrudRepository<UserContact, Long> {
	UserContact findByUserId(long userId);
}
