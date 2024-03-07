package com.app.Calendar_BE.controllers;

import com.app.Calendar_BE.models.Note;
import com.app.Calendar_BE.repositories.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/notes")
@CrossOrigin(origins = "http://localhost:5173")
public class NoteController {
    private final NoteRepository noteRepository;


    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping("/{username}")
    public void saveNote(@PathVariable String username, @RequestBody Note note) {
        note.setUsername(username);
        noteRepository.save(note);
    }
}
