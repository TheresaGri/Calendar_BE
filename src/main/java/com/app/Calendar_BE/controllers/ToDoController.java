package com.app.Calendar_BE.controllers;

import com.app.Calendar_BE.models.RegistrationDTO;
import com.app.Calendar_BE.models.ToDo;
import com.app.Calendar_BE.models.User;
import com.app.Calendar_BE.repositories.ToDoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class ToDoController {
    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @PostMapping("/{username}")
    public void saveNewToDo(@PathVariable String username, @RequestBody ToDo toDo) {
        toDo.setUsername(username);
        toDoRepository.save(toDo);
    }


}
