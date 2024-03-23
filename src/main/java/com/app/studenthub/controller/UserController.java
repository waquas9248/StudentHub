package com.app.studenthub.controller;

import com.app.studenthub.model.User;
import com.app.studenthub.service.UserService;
import com.app.studenthub.util.YearOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<User>> getAllUsersByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(userService.getAllUsersByFirstName(firstName));
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<User>> getAllUsersByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(userService.getAllUsersByLastName(lastName));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<User>> getAllUsersByCountry(@PathVariable String country) {
        return ResponseEntity.ok(userService.getAllUsersByCountry(country));
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<List<User>> getAllUsersByMajor(@PathVariable String major) {
        return ResponseEntity.ok(userService.getAllUsersByMajor(major));
    }

    @GetMapping("/yearOfStudy/{yearOfStudy}")
    public ResponseEntity<List<User>> getAllUsersByYearOfStudy(@PathVariable YearOfStudy yearOfStudy) {
        return ResponseEntity.ok(userService.getAllUsersByYearOfStudy(yearOfStudy));
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<User>> getAllUsersByRole(@PathVariable Long roleId) {
        return ResponseEntity.ok(userService.getAllUsersByRole(roleId));
    }

    @GetMapping("/interest/{interestId}")
    public ResponseEntity<List<User>> getAllUsersByInterest(@PathVariable Long interestId) {
        return ResponseEntity.ok(userService.getAllUsersByInterest(interestId));
    }

    @GetMapping("/connection/{connectionId}")
    public ResponseEntity<List<User>> getAllUsersByConnection(@PathVariable Long connectionId) {
        return ResponseEntity.ok(userService.getAllUsersByConnection(connectionId));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
