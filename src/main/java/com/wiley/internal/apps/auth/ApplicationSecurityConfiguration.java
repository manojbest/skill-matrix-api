//package com.wiley.internal.apps.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "true")
//public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//    private WileyUserDetailsService userDetailsService;
//	
//	@Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//		
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setAuthoritiesMapper(authoritiesMapper());
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return provider;
//    }
//		
//	@Bean
//    public GrantedAuthoritiesMapper authoritiesMapper(){
//        SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
//        authorityMapper.setConvertToUpperCase(true);
//        authorityMapper.setDefaultAuthority("USER");
//        return authorityMapper;
//    }
//	
//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//}
