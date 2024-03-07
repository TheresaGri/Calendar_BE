package com.app.Calendar_BE.repositories;

import com.app.Calendar_BE.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    Optional<ToDo> findToDoByUsername(String username);
    List<ToDo> findToDosByUsername(String username);
}
