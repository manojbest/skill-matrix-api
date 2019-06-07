package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.dto.UserSkillSearch;

public interface UserSkillService {

	UserSkill createSkillForUser(UserSkill userSkill);
		
	List<UserSkill> getSkillForUser(String username);
	
	List<UserSkill> filterUsersForSkills(List<UserSkillSearch> userSkillSearchList);

}
