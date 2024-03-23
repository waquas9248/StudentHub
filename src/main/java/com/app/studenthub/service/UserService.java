package com.app.studenthub.service;

import com.app.studenthub.model.User;
import com.app.studenthub.repository.UserRepository;
import com.app.studenthub.util.YearOfStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUsersByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }

    public List<User> getAllUsersByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName);
    }

    public List<User> getAllUsersByCountry(String country) {
        return userRepository.findAllByCountry(country);
    }

    public List<User> getAllUsersByMajor(String major) {
        return userRepository.findAllByMajor(major);
    }

    public List<User> getAllUsersByYearOfStudy(YearOfStudy yearOfStudy) {
        return userRepository.findAllByYearOfStudy(yearOfStudy);
    }

    public List<User> getAllUsersByRole(Long roleId) {
        return userRepository.findAllByRole_Id(roleId);
    }

    public List<User> getAllUsersByInterest(Long interestId) {
        return userRepository.findAllByInterest_Id(interestId);
    }

    public List<User> getAllUsersByConnection(Long connectionId) {
        return userRepository.findAllByConnection_Id(connectionId);
    }


    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setCountry(userDetails.getCountry());
            existingUser.setProgram(userDetails.getProgram());
            existingUser.setMajor(userDetails.getMajor());
            existingUser.setYearOfStudy(userDetails.getYearOfStudy());
            existingUser.setInterests(userDetails.getInterests());
            existingUser.setRole(userDetails.getRole());
            existingUser.setCreatedAt(userDetails.getCreatedAt());
            existingUser.setConnections(userDetails.getConnections());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
