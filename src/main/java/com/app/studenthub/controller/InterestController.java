package com.app.studenthub.controller;

import com.app.studenthub.model.Interest;
import com.app.studenthub.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interests")
public class InterestController {

    private final InterestService interestService;

    @Autowired
    public InterestController(InterestService interestService) {
        this.interestService = interestService;
    }

    @GetMapping
    public ResponseEntity<List<Interest>> getAllInterests() {
        List<Interest> interests = interestService.getAllInterests();
        return new ResponseEntity<>(interests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interest> getInterestById(@PathVariable Long id) {
        return interestService.getInterestById(id)
                .map(interest -> new ResponseEntity<>(interest, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Interest> createInterest(@RequestBody Interest interest) {
        Interest createdInterest = interestService.createInterest(interest);
        return new ResponseEntity<>(createdInterest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interest> updateInterest(@PathVariable Long id, @RequestBody Interest interestDetails) {
        try {
            Interest updatedInterest = interestService.updateInterest(id, interestDetails);
            return new ResponseEntity<>(updatedInterest, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInterest(@PathVariable Long id) {
        try {
            interestService.deleteInterest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
