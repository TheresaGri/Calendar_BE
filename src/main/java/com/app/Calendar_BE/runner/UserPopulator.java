package com.app.Calendar_BE.runner;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserPopulator {

    @Bean
    ApplicationRunner run() {
        return args -> {};
    }
}
