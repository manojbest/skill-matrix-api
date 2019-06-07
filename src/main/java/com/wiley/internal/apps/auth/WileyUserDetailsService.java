//package com.wiley.internal.apps.auth;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.wiley.internal.apps.domain.UserAuthGroup;
//import com.wiley.internal.apps.domain.User;
//import com.wiley.internal.apps.repo.UserAuthGroupRepository;
//import com.wiley.internal.apps.repo.UserRepository;
//
//import java.util.List;
//
//@Service
//public class WileyUserDetailsService  implements UserDetailsService{
//
//    private final UserRepository userRepository;
//    private final UserAuthGroupRepository authGroupRepository;
//
//    public WileyUserDetailsService(UserRepository userRepository, UserAuthGroupRepository authGroupRepository){
//        super();
//        this.userRepository = userRepository;
//        this.authGroupRepository = authGroupRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = this.userRepository.findById(username).get();
//        if(null == user){
//            throw new UsernameNotFoundException("cannot find username: " + username);
//        }
//        List<UserAuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
//        return new WileyUserPrincipal(user, authGroups);
//    }
//    
//    
//}
