package com.wiley.internal.apps.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wiley.internal.apps.domain.User;
import com.wiley.internal.apps.domain.UserAuthGroup;
import com.wiley.internal.apps.repo.UserAuthGroupRepository;
import com.wiley.internal.apps.repo.UserRepository;

@Controller
public class AuthController {
	
//	@Autowired
//	private WileyUserDetailsService wileyUserDetailsService;
	
	@Autowired
	private UserAuthGroupRepository userAuthGroupRepository;
	
	@Autowired
	private UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home(@AuthenticationPrincipal OidcUser oidcUser) {
    	
    	User user = userRepository.findById(oidcUser.getEmail()).get();
    	if(user == null) {
    		user = new User();
    		user.setUserName(oidcUser.getEmail());
    		user = userRepository.save(user);
    		System.out.println(user.getDesignation());
    		UserAuthGroup authGroup = new UserAuthGroup();
    		authGroup.setAuthGroup("USER");
    		authGroup.setUsername(user.getUserName());
    		authGroup = userAuthGroupRepository.save(authGroup);
    		
    	}
        return "Welcome, " + user.getDesignation() + " "+ userAuthGroupRepository.findByUsername(oidcUser.getEmail());
    }

    @RequestMapping("/attributes")
    @ResponseBody
    public String attributes(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAttributes().toString();
    }

    @RequestMapping("/authorities")
    @ResponseBody
    public String authorities(@AuthenticationPrincipal OidcUser oidcUser) {
        return oidcUser.getAuthorities().toString();
    }
    
}