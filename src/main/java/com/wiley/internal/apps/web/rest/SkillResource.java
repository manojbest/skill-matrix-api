package com.wiley.internal.apps.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.internal.apps.domain.Skill;
import com.wiley.internal.apps.domain.UserSkill;
import com.wiley.internal.apps.dto.UserSkillSearch;
import com.wiley.internal.apps.service.SkillService;
import com.wiley.internal.apps.service.UserSkillService;

@RestController
public class SkillResource {

	private SkillService skillService;

	private UserSkillService userSkillService;

	@Autowired
	public SkillResource(final SkillService skillService, final UserSkillService userSkillService) {
		this.skillService = skillService;
		this.userSkillService = userSkillService;
	}

	@PostMapping("/v1/skills")
	public ResponseEntity<Skill> handleSkillCreateAndUpdate(@Valid @RequestBody Skill skill) {
		return new ResponseEntity<>(this.skillService.createSkill(skill), HttpStatus.CREATED);
	}
	
    @PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/skills/{skillId}")
	public Skill handleSkillGet(@PathVariable Long skillId) {
		return skillService.findById(skillId);
	}
	
//  @PreAuthorize("hasRole('ROLE_USER')")
//	@GetMapping("/v1/skills/{skillName}")
//	public List<Skill> handleSkillGet(@PathVariable String skillName) {
//		return this.skillService.findSkillByName(skillName);
//	}
    
	@GetMapping("/v1/skills/{userName}")
	public List<UserSkill> handleSkillGet(@PathVariable String userName) {
		return userSkillService.getSkillForUser(userName);
	}

	@GetMapping("/v1/skills")
	public List<Skill> handleSkillGetAll() {
		return skillService.retrieveAllSkills();
	}

	@DeleteMapping("/v1/skills/{skillId}")
	public void handleSkillDelete(@PathVariable Long skillId) {
				skillService.deleteSkill(skillId);
	}

	@GetMapping("/v1/skills/users/skillusersearch")
	public List<UserSkill> handleSkillsUsersSearch(@RequestParam String filter) {
		// sample filter =
		// skillId::1200,skillLevelId::2502;skillId::1201,skillLevelId::2501
		List<UserSkillSearch> usersSkills = new ArrayList<>();
		String[] groups = filter.split(";");

		for (String group : groups) {
			UserSkillSearch userSkill = new UserSkillSearch();
			String[] paramGroups = group.split(",");
			for (String paramGroup : paramGroups) {
				String[] params = paramGroup.split("::");

				if (params[0].equals("skillId")) {
					userSkill.setSkillId(Long.parseLong(params[1]));
				}

				if (params[0].equals("skillLevelId")) {
					userSkill.setSkillLevelId(Long.parseLong(params[1]));
				}

			}
			usersSkills.add(userSkill);
		}

		return this.userSkillService.filterUsersForSkills(usersSkills);
	}

}
