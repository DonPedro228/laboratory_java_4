package com.example.demo.service;

import com.example.demo.model.Village;
import com.example.demo.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VillageService {

    private final VillageRepository villageRepository;

    @Autowired
    public VillageService(VillageRepository villageRepository) {
        this.villageRepository = villageRepository;
    }

    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }

    public Optional<Village> getVillageById(Long id) {
        return villageRepository.findById(id);
    }

    public Village createVillage(Village village) {
        return villageRepository.save(village);
    }

    public Village updateVillage(Long id, Village updatedVillage) {
        if (villageRepository.existsById(id)) {
            updatedVillage.setId(id);
            return villageRepository.save(updatedVillage);
        }
        return null;
    }

    public boolean deleteVillage(Long id) {
        if (villageRepository.existsById(id)) {
            villageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

