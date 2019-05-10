package com.myprofile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.entity.UserContact;
import com.myprofile.repository.UserContactRepository;
import com.myprofile.service.UserContactService;

@Service
public class UserContactServiceImpl implements UserContactService {

	@Autowired
	private UserContactRepository userContactRepository;

	@Override
	public UserContact findByUserId(int userId) {
		return userContactRepository.findByUserId(userId);
	}

	@Override
	public void save(UserContact theContact) {
		userContactRepository.save(theContact);
	}

	@Override
	public void delete(UserContact theContact) {
		userContactRepository.delete(theContact);
	}
}
