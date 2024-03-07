package com.app.Calendar_BE.models;

import java.util.List;

public class UserDTO {

    private List<Appointment> userAppointments;
    private List<Note> userNotes;
    private List<ToDo> userToDos;

    public UserDTO(List<Appointment> userAppointments, List<Note> userNotes, List<ToDo> userToDos) {
        this.userAppointments = userAppointments;
        this.userNotes = userNotes;
        this.userToDos = userToDos;
    }

    public List<Appointment> getUserAppointments() {
        return userAppointments;
    }

    public void setUserAppointments(List<Appointment> userAppointments) {
        this.userAppointments = userAppointments;
    }

    public List<Note> getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(List<Note> userNotes) {
        this.userNotes = userNotes;
    }

    public List<ToDo> getUserToDos() {
        return userToDos;
    }

    public void setUserToDos(List<ToDo> userToDos) {
        this.userToDos = userToDos;
    }
}
