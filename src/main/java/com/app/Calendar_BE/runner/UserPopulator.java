package com.app.Calendar_BE.runner;

import com.app.Calendar_BE.models.Role;
import com.app.Calendar_BE.repositories.RoleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class UserPopulator {
    @Bean
    ApplicationRunner run(RoleRepository roleRepository) {
        return args -> {
            Role admin = roleRepository.save(new Role("ADMIN"));
            Role user = roleRepository.save(new Role("USER"));

        };
    }
}
