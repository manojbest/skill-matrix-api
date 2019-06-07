package com.wiley.internal.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wiley.internal.apps.domain.User;

public interface UserRepository extends JpaRepository<User, String> { 
	
	User findUsersByUserName(String userName);
	
	List<User> findByUserNameIgnoreCaseContaining(String userName);  
			 
}

