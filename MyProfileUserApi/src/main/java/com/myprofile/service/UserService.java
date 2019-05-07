package com.myprofile.service;

import java.util.Set;

import com.myprofile.entity.User;
import com.myprofile.entity.UserRole;

public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
}
