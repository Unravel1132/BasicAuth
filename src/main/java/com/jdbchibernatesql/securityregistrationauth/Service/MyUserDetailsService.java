package com.jdbchibernatesql.securityregistrationauth.Service;


import com.jdbchibernatesql.securityregistrationauth.Config.MyUserDetails;
import com.jdbchibernatesql.securityregistrationauth.Entity.MyUser;
import com.jdbchibernatesql.securityregistrationauth.Repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private  MyUserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = userRepository.findByUsername(username);
        return myUser.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));


    }


}
