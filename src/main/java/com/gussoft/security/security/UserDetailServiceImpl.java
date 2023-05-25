package com.gussoft.security.security;

import com.gussoft.security.models.Users;
import com.gussoft.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users data = repository.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("el usuario con email " + email +" no existe!"));

        return new UserDetailsImpl(data);
    }

}
