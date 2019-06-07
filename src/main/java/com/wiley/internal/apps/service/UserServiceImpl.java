package com.wiley.internal.apps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.exception.UserNotFoundException;
import com.wiley.internal.apps.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> retrieveAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public void deleteUser(String userName) {
		 this.userRepository.deleteById(userName);
	}

	@Override
	public User findUser(String userName) {
		
	Optional<User> userOprtional = this.userRepository.findById(userName);
		
		if (!userOprtional.isPresent()) {
			throw new UserNotFoundException("User does not exsists :: " + userName);
		}
		
		return userOprtional.get();
	}

	@Override
	public List<User> findByUserNameIgnoreCaseContaining(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserNameIgnoreCaseContaining(userName);
	}

}
