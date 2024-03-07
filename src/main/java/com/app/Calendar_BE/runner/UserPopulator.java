package com.app.Calendar_BE.runner;

import com.app.Calendar_BE.models.*;
import com.app.Calendar_BE.repositories.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class UserPopulator {
    @Bean
    ApplicationRunner run(PasswordEncoder passwordEncode, RoleRepository roleRepository, UserRepository userRepository, ToDoRepository toDoRepository, AppointmentRepository appointmentRepository, NoteRepository noteRepository) {
        return args -> {
            Role admin = roleRepository.save(new Role("ADMIN"));
            Role user = roleRepository.save(new Role("USER"));
            Set<Role> roles = new HashSet<>();
            roles.add(user);
            roles.add(admin);
            User user1 = new User("Theresa",  passwordEncode.encode("1234"), roles );
            userRepository.save(user1);
            ToDo toDo = new ToDo(user1.getUsername(),"test to do", false);
            LocalDate date = LocalDate.of(2020, 1, 8);
            LocalTime ltime = LocalTime.now();
            LocalDateTime now = LocalDateTime.now();
            Appointment appointment = new Appointment(user1.getUsername(),"test appointment",date,ltime);
            Note note = new Note(user1.getUsername(),now,date);
            toDoRepository.save(toDo);
            appointmentRepository.save(appointment);
            noteRepository.save(note);
        };
    }
}
