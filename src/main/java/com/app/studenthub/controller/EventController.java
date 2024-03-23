package com.app.studenthub.controller;

import com.app.studenthub.model.Event;
import com.app.studenthub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(event -> new ResponseEntity<>(event, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Event> getEventByName(@PathVariable String name) {
        return eventService.getEventByName(name)
                .map(event -> new ResponseEntity<>(event, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/start/{startTime}")
    public ResponseEntity<List<Event>> getEventsByStartTime(@PathVariable("startTime") LocalDateTime startTime) {
        List<Event> events = eventService.getAllEventsByEventStartTime(startTime);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/end/{endTime}")
    public ResponseEntity<List<Event>> getEventsByEndTime(@PathVariable("endTime") LocalDateTime endTime) {
        List<Event> events = eventService.getAllEventsByEventEndTime(endTime);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        try {
            Event updatedEvent = eventService.updateEvent(id, eventDetails);
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
