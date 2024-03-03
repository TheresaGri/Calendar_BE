package com.app.Calendar_BE.repositories;

import com.app.Calendar_BE.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}
