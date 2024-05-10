package com.jdbchibernatesql.securityregistrationauth.Config;

import com.jdbchibernatesql.securityregistrationauth.Entity.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private MyUser myUser;

    public MyUserDetails(MyUser myUser) {
        this.myUser = myUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.stream(myUser.getRoles().split(", "))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return myUser.getPassword();
    }

    @Override
    public String getUsername() {
        return myUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
