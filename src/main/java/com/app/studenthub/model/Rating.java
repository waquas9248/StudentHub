package com.app.studenthub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "outlet_id", referencedColumnName = "id")
    private Outlet outlet;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors, getters, and setters

    // Relationships
    // Add relationships here


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
