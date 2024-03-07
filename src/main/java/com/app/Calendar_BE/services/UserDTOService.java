package com.app.Calendar_BE.services;

import com.app.Calendar_BE.models.Appointment;
import com.app.Calendar_BE.models.Note;
import com.app.Calendar_BE.models.ToDo;
import com.app.Calendar_BE.models.UserDTO;
import com.app.Calendar_BE.repositories.AppointmentRepository;
import com.app.Calendar_BE.repositories.NoteRepository;
import com.app.Calendar_BE.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        return new UserDTO(appointmentList,noteList,toDoList);
    }

    public UserDTO getUserDTOByDate(String username, LocalDate date) {
        List<Appointment> appointmentList = appointmentRepository.
                findAppointmentsByUsername(username).
                stream().
                filter(appointment -> appointment.getDate().equals(date)).
                collect(Collectors.toList());;
        List<Note> noteList = noteRepository.
                findNotesByUsername(username).
                stream().
                filter(note -> note.getDate().equals(date)).
                collect(Collectors.toList());
        List<ToDo> toDoList = toDoRepository.
                findToDosByUsername(username).
                stream().
                filter(toDo -> toDo.getDate().equals(date)).
                collect(Collectors.toList());
        return new UserDTO(appointmentList, noteList, toDoList);
    }
}
