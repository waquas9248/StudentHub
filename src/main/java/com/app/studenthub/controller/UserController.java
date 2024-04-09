package com.app.studenthub.controller;

import com.app.studenthub.model.User;
import com.app.studenthub.service.UserService;
import com.app.studenthub.util.YearOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
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


    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/secondaryEmail/{secondaryEmail}")
    public ResponseEntity<User> getUserBySecondaryEmail(@PathVariable String secondaryEmail) {
        return userService.getUserBySecondaryEmail(secondaryEmail)
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
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User existingUser = userService.getUserByEmail(user.getEmail()).orElse(null);
        if (existingUser != null) {
            // User already exists
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<User> updateUserByEmail(@PathVariable String email, @Valid @RequestBody User userDetails) {
        return userService.getUserByEmail(email).map(existingUser -> {
            // Update user details. Exclude non-updatable fields like createdAt or id.
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setCountry(userDetails.getCountry());
            existingUser.setProgram(userDetails.getProgram());
            existingUser.setMajor(userDetails.getMajor());
            existingUser.setYearOfStudy(userDetails.getYearOfStudy());
            existingUser.setInterests(userDetails.getInterests());
            existingUser.setRole(userDetails.getRole());
            // Assume interests and roles are correctly managed to avoid direct replacement issues.

            User updatedUser = userService.createUser(existingUser); // Reuse createUser for simplicity; consider a dedicated update method.
            return ResponseEntity.ok(updatedUser);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        return userService.getUserById(id).map(existingUser -> {
            // Simplified; in a real app, consider checking if the logged-in user is allowed to update this user.
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setCountry(userDetails.getCountry());
            existingUser.setProgram(userDetails.getProgram());
            existingUser.setMajor(userDetails.getMajor());
            existingUser.setYearOfStudy(userDetails.getYearOfStudy());
            existingUser.setInterests(userDetails.getInterests());
            existingUser.setRole(userDetails.getRole());

            User updatedUser = userService.createUser(existingUser);
            return ResponseEntity.ok(updatedUser);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
