package com.app.studenthub.service;

import com.app.studenthub.model.Attendee;
import com.app.studenthub.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Autowired
    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public List<Attendee> getAllAttendees() {
        return new ArrayList<>(attendeeRepository.findAll());
    }

    public Optional<Attendee> getAttendeeById(Long id) {
        return attendeeRepository.findById(id);
    }

    public Attendee createAttendee(Attendee attendee) {
        attendee.setCreatedAt(LocalDateTime.now());
        return attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long id) {
        attendeeRepository.deleteById(id);
    }

    public List<Attendee> getAttendeesByUserId(Long userId) {
        return attendeeRepository.findByUserId(userId);
    }

    public List<Attendee> getAttendeesByEventId(Long eventId) {
        return attendeeRepository.findByEventId(eventId);
    }
}
