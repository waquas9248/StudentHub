package com.app.studenthub.controller;

import com.app.studenthub.model.Rating;
import com.app.studenthub.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id)
                .map(rating -> new ResponseEntity<>(rating, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(ratingService.getAllRatingsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/outlet/{outletId}")
    public ResponseEntity<List<Rating>> getAllRatingsByOutletId(@PathVariable Long outletId) {
        return new ResponseEntity<>(ratingService.getAllRatingsByOutletId(outletId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createdRating = ratingService.createRating(rating);
        return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @RequestBody Rating ratingDetails) {
        try {
            Rating updatedRating = ratingService.updateRating(id, ratingDetails);
            return new ResponseEntity<>(updatedRating, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable Long id) {
        try {
            ratingService.deleteRating(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
