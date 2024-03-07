package com.app.Calendar_BE.controllers;

import com.app.Calendar_BE.models.UserDTO;
import com.app.Calendar_BE.services.UserDTOService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/userDTO")
@CrossOrigin(origins = "http://localhost:5173")
public class UserDTOController {
    private final UserDTOService userDTOService;

    public UserDTOController(UserDTOService userDTOService) {
        this.userDTOService = userDTOService;
    }

    @GetMapping(value = "/{username}", produces = "application/json")
    public UserDTO getUserDTO(@PathVariable String username) {
        return userDTOService.getUserDTO(username);
    }

    @GetMapping(value = "/{username}/{date}", produces = "application/json")
    public UserDTO getUserDTOByDate(@PathVariable String username, @PathVariable LocalDate date) {
        return userDTOService.getUserDTOByDate(username, date);
    }

}
