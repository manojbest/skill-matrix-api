package com.wiley.internal.apps.service;

import java.util.List;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.UserSkill;

public interface SkillService {
	
	Skill createSkill(Skill skill);
	
	void deleteSkill(Long skillId);
	
	List<Skill> findSkillByName(String skillName);
	
	List<Skill> retrieveAllSkills();
	
	Skill findById(Long id);

}
