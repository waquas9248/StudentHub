package com.app.studenthub.service;

import com.app.studenthub.model.Rating;
import com.app.studenthub.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> getAllRatingsByUserId(Long id) {
        return ratingRepository.findAllByUser_Id(id);
    }

    public List<Rating> getAllRatingsByOutletId(Long id) {
        return ratingRepository.findAllByOutlet_Id(id);
    }

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Rating ratingDetails) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating existingRating = optionalRating.get();
            existingRating.setOutlet(ratingDetails.getOutlet());
            existingRating.setUser(ratingDetails.getUser());
            existingRating.setRating(ratingDetails.getRating());
            existingRating.setBody(ratingDetails.getBody());
            existingRating.setCreatedAt(ratingDetails.getCreatedAt());
            return ratingRepository.save(existingRating);
        } else {
            throw new RuntimeException("Rating not found with id: " + id);
        }
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
