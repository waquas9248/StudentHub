package com.app.studenthub.controller;

import com.app.studenthub.dto.UserDTO;
import com.app.studenthub.model.Interest;
import com.app.studenthub.model.Role;
import com.app.studenthub.model.User;
import com.app.studenthub.service.InterestService;
import com.app.studenthub.service.UserService;
import com.app.studenthub.util.YearOfStudy;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    private final InterestService interestService;
 ;

    @Autowired
    public UserController(UserService userService, InterestService interestService) {
        this.userService = userService;
        this.interestService = interestService;
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

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String userEmail = Arrays.stream(cookies)
                .filter(cookie -> "userEmail".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (userEmail == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return userService.getUserByEmail(userEmail)
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

//    @GetMapping("/role/{roleId}")
//    public ResponseEntity<List<User>> getAllUsersByRole(@PathVariable Long roleId) {
//        return ResponseEntity.ok(userService.getAllUsersByRole(roleId));
//    }

    @GetMapping("/interest/{interestId}")
    public ResponseEntity<List<User>> getAllUsersByInterest(@PathVariable Long interestId) {
        return ResponseEntity.ok(userService.getAllUsersByInterest(interestId));
    }

    @GetMapping("/connection/{connectionId}")
    public ResponseEntity<List<User>> getAllUsersByConnection(@PathVariable Long connectionId) {
        return ResponseEntity.ok(userService.getAllUsersByConnection(connectionId));
    }


    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO, HttpServletRequest request) {
        String userEmail = extractUserEmailFromCookies(request);
        if (userEmail == null || userEmail.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User email is missing.");
        }

        // Check if user already exists
        Optional<User> existingUser = userService.getUserByEmail(userEmail);
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists.");
        }

        User user = convertDtoToUser(userDTO, userEmail);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data.");
        }

        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    private User convertDtoToUser(UserDTO userDTO, String userEmail) {
        User user = new User();
        user.setEmail(userEmail);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setCountry(userDTO.getCountry());
        user.setProgram(userDTO.getProgram());
        user.setMajor(userDTO.getMajor());
        user.setYearOfStudy(userDTO.getYearOfStudy());

        System.out.println("Received interest IDs: " + userDTO.getInterestIds());
        if (userDTO.getInterestIds() == null) {
            System.out.println("No interest IDs provided");
        }
       // Code to convert DTO to entity


        List<Interest> interests = userDTO.getInterestIds().stream()
                .map(interestService::getInterestById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        user.setInterests(interests);
        return user;
    }

    private String extractUserEmailFromCookies(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> "userEmail".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
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
//            existingUser.setRole(userDetails.getRole());

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

    @GetMapping("/recommendations")
    public ResponseEntity<List<User>> getRecommendations(HttpServletRequest request) {
        ResponseEntity<User> currentUserResponse = getCurrentUser(request);
        if (currentUserResponse.getStatusCode() != HttpStatus.OK) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User currentUser = currentUserResponse.getBody();
        List<User> recommendedUsers = userService.recommendUsers(currentUser);
        System.out.println("Recommended users: " + recommendedUsers);
        return ResponseEntity.ok(recommendedUsers);
    }



}
