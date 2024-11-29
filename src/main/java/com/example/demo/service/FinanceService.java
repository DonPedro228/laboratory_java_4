package com.example.demo.service;

import com.example.demo.model.Finance;
import com.example.demo.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    @Autowired
    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public List<Finance> getAllFinances() {
        return financeRepository.findAll();
    }

    public Optional<Finance> getFinanceById(Long id) {
        return financeRepository.findById(id);
    }

    public Finance createFinance(Finance finance) {
        finance.setProfit(calculateProfit(finance));  // обчислення прибутку
        return financeRepository.save(finance);
    }

    public Finance updateFinance(Long id, Finance updatedFinance) {
        if (financeRepository.existsById(id)) {
            updatedFinance.setId(id);
            updatedFinance.setProfit(calculateProfit(updatedFinance)); // оновлення прибутку
            return financeRepository.save(updatedFinance);
        }
        return null;
    }

    public boolean deleteFinance(Long id) {
        if (financeRepository.existsById(id)) {
            financeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private double calculateProfit(Finance finance) {
        double discountAmount = finance.getIncome() * (finance.getDiscount() / 100);
        return finance.getIncome() - finance.getExpenses() - discountAmount;
    }
}
