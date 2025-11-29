package com.example.gyak_beadando.service;

import com.example.gyak_beadando.entity.User;
import com.example.gyak_beadando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Felhasználó nem található: " + username);
        }

        // Az adatbázisban a role mező pl. "ROLE_USER" vagy "ROLE_ADMIN"
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                // hasRole("ADMIN") → "ROLE_ADMIN" kell, ezért authorities-t használunk:
                .authorities(user.getRole())
                .build();
    }
}