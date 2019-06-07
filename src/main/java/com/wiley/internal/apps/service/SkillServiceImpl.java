package com.wiley.internal.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.repo.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	private SkillRepository skillRepository;
	
	@Autowired
	public SkillServiceImpl(final SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	@Override
	public Skill createSkill(Skill skill) {
		return this.skillRepository.save(skill);
	}

	@Override
	public List<Skill> retrieveAllSkills() {
		return this.skillRepository.findAll();
	}

	@Override
	public void deleteSkill(Long skillId) {
		this.skillRepository.deleteById(skillId);		
	}

	public List<Skill> findSkillByName(String skillName) {
		return this.skillRepository.findByNameContaining(skillName);
	}

	@Override
	public Skill findById(Long id) {
		// TODO Auto-generated method stub
		return skillRepository.findById(id).get();
	}

}
