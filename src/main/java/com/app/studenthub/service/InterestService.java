package com.app.studenthub.service;

import com.app.studenthub.model.Interest;
import com.app.studenthub.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestService {

    private final InterestRepository interestRepository;

    @Autowired
    public InterestService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    public List<Interest> getAllInterests() {
        return interestRepository.findAll();
    }

    public Optional<Interest> getInterestById(Long id) {
        return interestRepository.findById(id);
    }

    public Interest createInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    public Interest updateInterest(Long id, Interest interestDetails) {
        Optional<Interest> optionalInterest = interestRepository.findById(id);
        if (optionalInterest.isPresent()) {
            Interest existingInterest = optionalInterest.get();
            existingInterest.setTitle(interestDetails.getTitle());
            return interestRepository.save(existingInterest);
        } else {
            throw new RuntimeException("Interest not found with id: " + id);
        }
    }

    public void deleteInterest(Long id) {
        interestRepository.deleteById(id);
    }
}
