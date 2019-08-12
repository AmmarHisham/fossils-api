package com.fossils.fossils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fossils.fossils.entity.User;
import com.fossils.fossils.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUserNameAndPassword(username, password);
	}
}
