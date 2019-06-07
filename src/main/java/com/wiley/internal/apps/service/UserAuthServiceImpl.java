package com.wiley.internal.apps.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.UserAuthGroup;
import com.wiley.internal.apps.repo.UserAuthGroupRepository;

@Service
public class UserAuthServiceImpl implements UserAuthService{

	@Autowired
	private UserAuthGroupRepository userAuthGroupRepository;
	
	@Override
	public List<String> getByUsername(String username) {
		
		return userAuthGroupRepository.findByUsername(username)
											.stream().map(UserAuthGroup::getAuthGroup)
											.collect(Collectors.toList());
	}

}
