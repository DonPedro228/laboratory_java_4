package com.example.demo.service;

import com.example.demo.model.Amenity;
import com.example.demo.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenityService {

    private final AmenityRepository amenityRepository;

    @Autowired
    public AmenityService(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    public Optional<Amenity> getAmenityById(Long id) {
        return amenityRepository.findById(id);
    }

    public Amenity createAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    public Amenity updateAmenity(Long id, Amenity updatedAmenity) {
        if (amenityRepository.existsById(id)) {
            updatedAmenity.setId(id);
            return amenityRepository.save(updatedAmenity);
        }
        return null;
    }

    public boolean deleteAmenity(Long id) {
        if (amenityRepository.existsById(id)) {
            amenityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

