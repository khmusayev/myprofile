package com.myprofile.service;

import com.myprofile.entity.UserContact;

public interface UserContactService {

	UserContact findByUserId(int userId);

	void save(UserContact theContact);

	void delete(UserContact theContact);
	
}
