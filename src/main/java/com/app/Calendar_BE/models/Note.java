package com.app.Calendar_BE.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private LocalDateTime creatingTime;
    private LocalDate date;



    public Note() {
    }

    public Note(String username, LocalDateTime creatingTime, LocalDate date) {
        this.username = username;
        this.creatingTime = creatingTime;
        this.date = date;
    }



    public LocalDateTime getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(LocalDateTime creatingTime) {
        this.creatingTime = creatingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
