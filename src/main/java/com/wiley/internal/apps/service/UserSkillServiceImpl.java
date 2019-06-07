package com.wiley.internal.apps.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.SkillLevel;
import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.dto.UserSkillSearch;
import com.wiley.internal.apps.exception.SkillLevelNotFoundException;
import com.wiley.internal.apps.exception.SkillNotFoundException;
import com.wiley.internal.apps.exception.UserNotFoundException;
import com.wiley.internal.apps.repo.SkillLevelRepository;
import com.wiley.internal.apps.repo.SkillRepository;
import com.wiley.internal.apps.repo.UserRepository;
import com.wiley.internal.apps.repo.UserSkillRepository;

@Service
public class UserSkillServiceImpl implements UserSkillService {
	
	private UserRepository userRepository;
	private SkillRepository skillRepository;
	private SkillLevelRepository skillLevelRepository;
	private UserSkillRepository userSkillRepository;

	public UserSkillServiceImpl(final UserRepository userRepository, final SkillRepository skillRepository, final SkillLevelRepository skillLevelRepository,
			final UserSkillRepository userSkillRepository) {
		this.userRepository = userRepository;
		this.skillRepository = skillRepository;
		this.skillLevelRepository = skillLevelRepository;
		this.userSkillRepository = userSkillRepository;
	}

	@Override
	public UserSkill createSkillForUser(UserSkill userSkill) {
		
		String userName = userSkill.getUser().getUserName();
		Optional<User> userOptional = this.userRepository.findById(userName);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User does not exsits :: " + userName);
		}
		
		Long skillId = userSkill.getSkill().getId();
		Optional<Skill> skillOptional = this.skillRepository.findById(skillId);
		
		if (!skillOptional.isPresent()) {
			throw new SkillNotFoundException("Skill does not exsits :: " + skillId);
		}
		
		Long skillLevelId = userSkill.getSkillLevel().getId();
		Optional<SkillLevel> skillLevelOptional = this.skillLevelRepository.findById(skillLevelId);
		
		if (!skillLevelOptional.isPresent()) {
			throw new SkillLevelNotFoundException("Skill Level does not exsits :: " + skillLevelId);
		}
		
		userSkill.setUser(userOptional.get());
		userSkill.setSkill(skillOptional.get());
		userSkill.setSkillLevel(skillLevelOptional.get());
		
		return this.userSkillRepository.save(userSkill);
	}

	@Override
	public List<UserSkill> getSkillForUser(String username) {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepository.findById(username);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("User does not exsits :: " + username);
		}
		return this.userSkillRepository.findByUser(user.get());
	}
	
	public List<UserSkill> filterUsersForSkills(List<UserSkillSearch> userSkillSearchList) {
		
		List<UserSkill> userSkillList = new ArrayList<>();
		
		userSkillSearchList.forEach(userSkillSearch -> {
			Long skillId = userSkillSearch.getSkillId();
			Optional<Skill> skillOptional = this.skillRepository.findById(skillId);
			
			if (!skillOptional.isPresent()) {
				throw new SkillNotFoundException("Skill does not exsits :: " + skillId);
			}
			
			Long skillLevelId = userSkillSearch.getSkillLevelId();
			Optional<SkillLevel> skillLevelOptional = this.skillLevelRepository.findById(skillLevelId);
			
			if (!skillLevelOptional.isPresent()) {
				throw new SkillLevelNotFoundException("Skill Level does not exsits :: " + skillLevelId);
			}
			
			Optional<UserSkill> userSkillOptional = this.userSkillRepository.findBySkillAndSkillLevel(skillOptional.get(), skillLevelOptional.get());
			
			if (userSkillOptional.isPresent()) {
				userSkillList.add(userSkillOptional.get());
			}
		});
		
		return userSkillList;

	}

}
