package com.example.demo.controller;

import com.example.demo.model.Amenity;
import com.example.demo.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amenities")
public class AmenityController {

    private final AmenityService amenityService;

    @Autowired
    public AmenityController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    @GetMapping
    public List<Amenity> getAllAmenities() {
        return amenityService.getAllAmenities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amenity> getAmenityById(@PathVariable Long id) {
        Optional<Amenity> amenity = amenityService.getAmenityById(id);
        return amenity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Amenity> createAmenity(@RequestBody Amenity amenity) {
        Amenity createdAmenity = amenityService.createAmenity(amenity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAmenity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amenity> updateAmenity(@PathVariable Long id, @RequestBody Amenity updatedAmenity) {
        Amenity amenity = amenityService.updateAmenity(id, updatedAmenity);
        return amenity != null ? ResponseEntity.ok(amenity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
        return amenityService.deleteAmenity(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
