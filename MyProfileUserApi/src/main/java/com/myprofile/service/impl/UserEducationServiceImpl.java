package com.myprofile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.entity.UserEducation;
import com.myprofile.repository.UserEducationRepository;
import com.myprofile.service.UserEducationService;

@Service
public class UserEducationServiceImpl implements UserEducationService {

	@Autowired
	private UserEducationRepository userEducationRepository;

	@Override
	public List<UserEducation> findAll(int userId) {
		return userEducationRepository.findByUserId(userId);
	}

	@Override
	public void save(UserEducation theEducation) {
		userEducationRepository.save(theEducation);
	}

	@Override
	public void delete(UserEducation theEducation) {
		userEducationRepository.delete(theEducation);
	}

}
