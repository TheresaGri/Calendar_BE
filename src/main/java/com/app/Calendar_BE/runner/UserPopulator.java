package com.app.Calendar_BE.runner;

import com.app.Calendar_BE.models.Role;
import com.app.Calendar_BE.models.ToDo;
import com.app.Calendar_BE.models.User;
import com.app.Calendar_BE.repositories.RoleRepository;
import com.app.Calendar_BE.repositories.ToDoRepository;
import com.app.Calendar_BE.repositories.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class UserPopulator {
    @Bean
    ApplicationRunner run(PasswordEncoder passwordEncode, RoleRepository roleRepository, UserRepository userRepository, ToDoRepository toDoRepository) {
        return args -> {
            Role admin = roleRepository.save(new Role("ADMIN"));
            Role user = roleRepository.save(new Role("USER"));
            Set<Role> roles = new HashSet<>();
            roles.add(user);
            roles.add(admin);
            User user1 = new User("Theresa",  passwordEncode.encode("1234"), roles );
            userRepository.save(user1);
            ToDo toDo = new ToDo(user1.getUsername(),"test to do", false);
            toDoRepository.save(toDo);
        };
    }
}
