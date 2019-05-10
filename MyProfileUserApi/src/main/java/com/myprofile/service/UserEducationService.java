package com.myprofile.service;

import java.util.List;

import com.myprofile.entity.UserEducation;

public interface UserEducationService {

	List<UserEducation> findAll(int userId);

	void save(UserEducation theEdu);

	void delete(UserEducation userEdu);
	
}
