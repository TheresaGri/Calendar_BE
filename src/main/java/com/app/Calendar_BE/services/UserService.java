package com.app.Calendar_BE.services;

import com.app.Calendar_BE.models.User;
import com.app.Calendar_BE.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    public UserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));

    }
    public long findIdByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        return user.getId();
    }
}
