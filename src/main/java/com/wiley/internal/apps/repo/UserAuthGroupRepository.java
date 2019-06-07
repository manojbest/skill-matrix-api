package com.wiley.internal.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.internal.apps.domain.UserAuthGroup;
import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;

public interface UserAuthGroupRepository extends JpaRepository<UserAuthGroup, Long> {
	
    List<UserAuthGroup> findByUsername(String username);
	
}
