package com.example.demo.controller;

import com.example.demo.model.Cottage;
import com.example.demo.service.CottageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cottages")
public class CottageController {
    private final CottageService cottageService;

    public CottageController(CottageService cottageService) {
        this.cottageService = cottageService;
    }

    @GetMapping
    public List<Cottage> getAllCottages() {
        return cottageService.getAllCottages();
    }

    @PostMapping
    public Cottage addCottage(@RequestBody Cottage cottage) {
        return cottageService.saveCottage(cottage);
    }

    @DeleteMapping("/{id}")
    public void deleteCottage(@PathVariable Long id) {
        cottageService.deleteCottage(id);
    }
}