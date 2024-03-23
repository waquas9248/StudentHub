package com.app.studenthub.service;

import com.app.studenthub.model.Event;
import com.app.studenthub.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Optional<Event> getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public List<Event> getAllEventsByEventStartTime(LocalDateTime eventStartTime) {
        return eventRepository.findAllByEventStartTimeGreaterThanEqual(eventStartTime);
    }

    public List<Event> getAllEventsByEventEndTime(LocalDateTime eventEndTime) {
        return eventRepository.findAllByEventEndTimeGreaterThanCurrentTimeAndEventEndTimeLessThanEqual(eventEndTime);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setName(eventDetails.getName());
            existingEvent.setDescription(eventDetails.getDescription());
            existingEvent.setEventStartTime(eventDetails.getEventStartTime());
            existingEvent.setEventEndTime(eventDetails.getEventEndTime());
            existingEvent.setActiveStatus(eventDetails.getActiveStatus());
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

