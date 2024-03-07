package com.app.Calendar_BE.services;

import com.app.Calendar_BE.models.Appointment;
import com.app.Calendar_BE.models.Note;
import com.app.Calendar_BE.models.ToDo;
import com.app.Calendar_BE.models.UserDTO;
import com.app.Calendar_BE.repositories.AppointmentRepository;
import com.app.Calendar_BE.repositories.NoteRepository;
import com.app.Calendar_BE.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDTOService {
    private final AppointmentRepository appointmentRepository;
    private final NoteRepository noteRepository;
    private final ToDoRepository toDoRepository;

    public UserDTOService(AppointmentRepository appointmentRepository, NoteRepository noteRepository, ToDoRepository toDoRepository) {
        this.appointmentRepository = appointmentRepository;
        this.noteRepository = noteRepository;
        this.toDoRepository = toDoRepository;
    }

    public UserDTO getUserDTO(String username) {
        List<Appointment> appointmentList = appointmentRepository.findAppointmentsByUsername(username);
        List<Note> noteList = noteRepository.findNotesByUsername(username);
        List<ToDo> toDoList = toDoRepository.findToDosByUsername(username);
        System.out.println(appointmentList);
        System.out.println(noteList);
        System.out.println(toDoList);
        UserDTO userDTO = new UserDTO(appointmentList,noteList,toDoList);
        System.out.println(userDTO);
        return userDTO;
    }
}
