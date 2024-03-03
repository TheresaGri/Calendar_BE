package com.app.Calendar_BE.services;

import com.app.Calendar_BE.models.LoginResponseDTO;
import com.app.Calendar_BE.models.Role;
import com.app.Calendar_BE.models.User;
import com.app.Calendar_BE.repositories.RoleRepository;
import com.app.Calendar_BE.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    public User registerUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new User(username, encodedPassword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);
            User authenticatedUser = (User) auth.getPrincipal();
            long userId = authenticatedUser.getId(); // Assuming getId() returns the userId

            return new LoginResponseDTO(authenticatedUser.getUsername(),userId,token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO("", 0,"");
        }
    }
}
