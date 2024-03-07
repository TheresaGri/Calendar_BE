package com.app.Calendar_BE.controllers;

import com.app.Calendar_BE.models.Appointment;
import com.app.Calendar_BE.repositories.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    @PostMapping("/{username}")
    public void saveAppointment(@PathVariable String username, @RequestBody Appointment appointment) {
        appointment.setUsername(username);
        appointmentRepository.save(appointment);
    }
}
