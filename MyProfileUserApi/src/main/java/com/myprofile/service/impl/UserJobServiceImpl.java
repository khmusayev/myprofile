package com.myprofile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.entity.UserJob;
import com.myprofile.repository.UserJobRepository;
import com.myprofile.service.UserJobService;

@Service
public class UserJobServiceImpl implements UserJobService {

	@Autowired
	private UserJobRepository userJobRepository;

	@Override
	public List<UserJob> findAll(int userId) {
		return userJobRepository.findByUserId(userId);
	}

	@Override
	public void save(UserJob theJob) {
		userJobRepository.save(theJob);
	}

	@Override
	public void delete(UserJob userJob) {
		userJobRepository.delete(userJob);
	}

}
