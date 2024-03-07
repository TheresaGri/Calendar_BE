package com.app.Calendar_BE.repositories;

import com.app.Calendar_BE.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository  extends JpaRepository<Note, Long> {
    List<Note> findNotesByUsername(String username);
}
