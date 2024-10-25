package com.project.app.service;

import com.project.app.entity.UserEntry;
import com.project.app.repo.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class usedetailsimp implements UserDetailsService {

    @Autowired
    private userrepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntry usr = repo.findByusername(username);
        if(usr != null)
        {
            return User.builder().username(usr.getUsername()).
                    password(usr.getPassword()).
                    roles(usr.getRoles().toArray(new String[0])).build();
        }
        throw new UsernameNotFoundException("Username nahi mila" + username);
    }
}
