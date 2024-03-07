package com.app.Calendar_BE.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String description;
    private LocalDate date;
    private LocalTime time;

    public Appointment() {
    }

    public Appointment(String username, String description, LocalDate date, LocalTime time) {
        this.username = username;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public Appointment(String description, LocalDate date, LocalTime time) {
        this.description = description;
        this.date = date;
        this.time = time;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
