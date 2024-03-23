package com.app.studenthub.service;

import com.app.studenthub.model.Location;
import com.app.studenthub.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    // Retrieve all locations
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    // Find a location by ID
    public Optional<Location> findLocationById(Long id) {
        return locationRepository.findById(id);
    }

    // Create a new location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    // Update an existing location
    public Location updateLocation(Long id, Location updatedLocation) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setStreetAddress(updatedLocation.getStreetAddress());
                    location.setCity(updatedLocation.getCity());
                    location.setState(updatedLocation.getState());
                    location.setZipCode(updatedLocation.getZipCode());
                    location.setCountry(updatedLocation.getCountry());
                    location.setLatitude(updatedLocation.getLatitude());
                    location.setLongitude(updatedLocation.getLongitude());
                    return locationRepository.save(location);
                })
                .orElseGet(() -> {
                    updatedLocation.setId(id);
                    return locationRepository.save(updatedLocation);
                });
    }

//
    // Delete a location
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}