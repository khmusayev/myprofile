package com.myprofile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myprofile.entity.UserJob;

public interface UserJobRepository extends CrudRepository<UserJob, Long> {
	List<UserJob> findByUserId(long userId);
}
