package com.myprofile.service;

import java.util.List;

import com.myprofile.entity.UserJob;

public interface UserJobService {

	List<UserJob> findAll(int userId);

	void save(UserJob theJob);

	void delete(UserJob userJob);
	
}
