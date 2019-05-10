package com.myprofile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.entity.UserEducation;

public interface UserEducationRepository extends CrudRepository<UserEducation, Long> {
	List<UserEducation> findByUserId(long userId);
}
