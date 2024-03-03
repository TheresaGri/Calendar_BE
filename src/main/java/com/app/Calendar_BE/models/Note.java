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
    private long userId;
    private LocalDateTime creatingTime;
    private LocalDate date;

    public Note(long userId, LocalDateTime creatingTime, LocalDate date) {
        this.userId = userId;
        this.creatingTime = creatingTime;
        this.date = date;
    }

    public Note() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
