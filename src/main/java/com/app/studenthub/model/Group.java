package com.app.studenthub.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "body", columnDefinition = "text",nullable = false)
    private String body;

//    @ManyToMany
//    @JoinTable(
//            name = "user_groups",
//            joinColumns = @JoinColumn(name = "group_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> users;

    // Constructors, getters, and setters

    // Relationships
    // Add relationships here


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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

}