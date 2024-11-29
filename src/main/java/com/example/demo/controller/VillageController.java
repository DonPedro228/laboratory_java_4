package com.example.demo.controller;

import com.example.demo.model.Village;
import com.example.demo.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/villages")
public class VillageController {

    private final VillageService villageService;

    @Autowired
    public VillageController(VillageService villageService) {
        this.villageService = villageService;
    }

    @GetMapping
    public List<Village> getAllVillages() {
        return villageService.getAllVillages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Village> getVillageById(@PathVariable Long id) {
        Optional<Village> village = villageService.getVillageById(id);
        return village.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Village> createVillage(@RequestBody Village village) {
        Village createdVillage = villageService.createVillage(village);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVillage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Village> updateVillage(@PathVariable Long id, @RequestBody Village updatedVillage) {
        Village village = villageService.updateVillage(id, updatedVillage);
        return village != null ? ResponseEntity.ok(village) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVillage(@PathVariable Long id) {
        return villageService.deleteVillage(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
