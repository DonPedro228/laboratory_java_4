package com.example.demo.controller;

import com.example.demo.model.Finance;
import com.example.demo.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/finances")
public class FinanceController {

    private final FinanceService financeService;

    @Autowired
    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping
    public List<Finance> getAllFinances() {
        return financeService.getAllFinances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finance> getFinanceById(@PathVariable Long id) {
        Optional<Finance> finance = financeService.getFinanceById(id);
        return finance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Finance> createFinance(@RequestBody Finance finance) {
        Finance createdFinance = financeService.createFinance(finance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFinance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Finance> updateFinance(@PathVariable Long id, @RequestBody Finance updatedFinance) {
        Finance finance = financeService.updateFinance(id, updatedFinance);
        return finance != null ? ResponseEntity.ok(finance) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinance(@PathVariable Long id) {
        return financeService.deleteFinance(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
