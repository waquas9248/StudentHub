package com.app.studenthub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "eventStartTime", nullable = false)
    private LocalDateTime eventStartTime;

    @Column(name = "eventEndTime", nullable = false)
    private LocalDateTime eventEndTime;

    @Column(name = "active_status")
    private boolean activeStatus;


    // Constructors, getters, and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalDateTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public LocalDateTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalDateTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }


}
