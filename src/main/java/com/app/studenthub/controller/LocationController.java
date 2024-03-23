package com.app.studenthub.controller;

import com.app.studenthub.model.Location;
import com.app.studenthub.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // Get all locations
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.findAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // Get a single location by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.findLocationById(id);
        return location.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new location
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location newLocation = locationService.saveLocation(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    // Update an existing location
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        Location updatedLocation = locationService.updateLocation(id, location);
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    // Delete a location
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
