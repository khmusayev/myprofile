package com.myprofile.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprofile.entity.User;
import com.myprofile.repository.UserRepository;
import com.myprofile.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) throws Exception {
		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {

			localUser = userRepository.save(user);
		}

		return localUser;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public Optional<User> findById(long theId) {
		return userRepository.findById(theId);
	}
	
	@Override
	public void save(User theEmployee) {
		userRepository.save(theEmployee);
	}

	@Override
	public void delete(long theId) {
		userRepository.deleteById(theId);
	}

}
