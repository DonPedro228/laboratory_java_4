package com.example.demo.service;

import com.example.demo.model.Cottage;
import com.example.demo.repository.CottageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageService {
    private final CottageRepository cottageRepository;

    public CottageService(CottageRepository cottageRepository) {
        this.cottageRepository = cottageRepository;
    }

    public List<Cottage> getAllCottages() {
        return cottageRepository.findAll();
    }

    public Cottage saveCottage(Cottage cottage) {
        return cottageRepository.save(cottage);
    }

    public void deleteCottage(Long id) {
        cottageRepository.deleteById(id);
    }
}
