package com.wiley.internal.apps.auth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "false")
public class ApplicationSecurityConfigurationDev extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	            .authorizeRequests()
	            .antMatchers("/**").permitAll()
	            .anyRequest().authenticated();
	}
}
