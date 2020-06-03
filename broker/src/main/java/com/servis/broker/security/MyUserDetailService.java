package com.servis.broker.security;

import com.servis.broker.model.Role;
import com.servis.broker.model.User;
import com.servis.broker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) throw new UsernameNotFoundException(s);
        //formatiramo nase roles tako da odgovaraju UserDetails
        //return new User(user.getUsername(), user.getPassword(), getAuthorities(user));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<SimpleGrantedAuthority> userAuthorities = new ArrayList<>();

        for (Role r : user.getRoles()) {
            userAuthorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName()));
        }
        return userAuthorities;
    }
}
