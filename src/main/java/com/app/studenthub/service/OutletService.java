package com.app.studenthub.service;

import com.app.studenthub.model.Outlet;
import com.app.studenthub.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.app.studenthub.util.OutletType;
@Service
public class OutletService {

    private final OutletRepository outletRepository;

    @Autowired
    public OutletService(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    public List<Outlet> getAllOutlets() {
        return outletRepository.findAll();
    }

    public Optional<Outlet> getOutletByName(String name) {
        return outletRepository.findByName(name);
    }

    public List<Outlet> getOutletsByRating(Float rating) {
        return outletRepository.findAllByRatingGreaterThanEqual(rating);
    }


    public List<Outlet> getAllOutletsByType(OutletType outletType) {
        return outletRepository.findAllByOutletType(outletType);
    }

    public Optional<Outlet> getOutletById(Long id) {
        return outletRepository.findById(id);
    }

    public Outlet createOutlet(Outlet outlet) {
        return outletRepository.save(outlet);
    }

    public Outlet updateOutlet(Long id, Outlet outletDetails) {
        Optional<Outlet> optionalOutlet = outletRepository.findById(id);
        if (optionalOutlet.isPresent()) {
            Outlet existingOutlet = optionalOutlet.get();
            existingOutlet.setName(outletDetails.getName());
            existingOutlet.setOutletType(outletDetails.getOutletType());
//            existingOutlet.setSubtype(outletDetails.getSubtype());
            existingOutlet.setLocation(outletDetails.getLocation());
            existingOutlet.setRating(outletDetails.getRating());
            existingOutlet.setBody(outletDetails.getBody());
            return outletRepository.save(existingOutlet);
        } else {
            throw new RuntimeException("Outlet not found with id: " + id);
        }
    }

    public void deleteOutlet(Long id) {
        outletRepository.deleteById(id);
    }
}
