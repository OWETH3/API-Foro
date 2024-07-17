package com.alura.api.infra.security;

import com.alura.api.users.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private IUserRepository model;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return model.findBylogin(username);
    }
}
