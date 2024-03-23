package com.app.studenthub.model;

import jakarta.persistence.*;

import com.app.studenthub.util.UserRole;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UserRole type;

    // Constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getType() {
        return type;
    }

    public void setType(UserRole type) {
        this.type = type;
    }
}