package com.app.studenthub.controller;

import com.app.studenthub.model.Attendee;
import com.app.studenthub.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    @Autowired
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<List<Attendee>> getAllAttendees() {
        List<Attendee> attendees = attendeeService.getAllAttendees();
        return ResponseEntity.ok(attendees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
        Optional<Attendee> attendee = attendeeService.getAttendeeById(id);
        return attendee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Attendee> createAttendee(@RequestBody Attendee attendee) {
        Attendee createdAttendee = attendeeService.createAttendee(attendee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttendee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
        attendeeService.deleteAttendee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Attendee>> getAttendeesByUserId(@PathVariable Long userId) {
        List<Attendee> attendees = attendeeService.getAttendeesByUserId(userId);
        return ResponseEntity.ok(attendees);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Attendee>> getAttendeesByEventId(@PathVariable Long eventId) {
        List<Attendee> attendees = attendeeService.getAttendeesByEventId(eventId);
        return ResponseEntity.ok(attendees);
    }
}
