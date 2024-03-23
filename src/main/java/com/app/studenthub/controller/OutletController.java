package com.app.studenthub.controller;

import com.app.studenthub.model.Outlet;
import com.app.studenthub.util.OutletType;
import com.app.studenthub.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outlets")
public class OutletController {

    private final OutletService outletService;

    @Autowired
    public OutletController(OutletService outletService) {
        this.outletService = outletService;
    }

    @GetMapping
    public ResponseEntity<List<Outlet>> getAllOutlets() {
        return new ResponseEntity<>(outletService.getAllOutlets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outlet> getOutletById(@PathVariable Long id) {
        return outletService.getOutletById(id)
                .map(outlet -> new ResponseEntity<>(outlet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Outlet> getOutletByName(@PathVariable String name) {
        return outletService.getOutletByName(name)
                .map(outlet -> new ResponseEntity<>(outlet, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Outlet>> getOutletsByRating(@PathVariable Float rating) {
        List<Outlet> outlets = outletService.getOutletsByRating(rating);
        return new ResponseEntity<>(outlets, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Outlet>> getAllOutletsByType(@PathVariable OutletType type) {
        List<Outlet> outlets = outletService.getAllOutletsByType(type);
        return new ResponseEntity<>(outlets, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Outlet> createOutlet(@RequestBody Outlet outlet) {
        Outlet createdOutlet = outletService.createOutlet(outlet);
        return new ResponseEntity<>(createdOutlet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Outlet> updateOutlet(@PathVariable Long id, @RequestBody Outlet outletDetails) {
        try {
            Outlet updatedOutlet = outletService.updateOutlet(id, outletDetails);
            return new ResponseEntity<>(updatedOutlet, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOutlet(@PathVariable Long id) {
        try {
            outletService.deleteOutlet(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
