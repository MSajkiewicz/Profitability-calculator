package com.lpg.profitabilitycalculator.repository;

import com.lpg.profitabilitycalculator.domain.FullCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private ProfitabilityCalculatorRepository profitabilityCalculatorRepository;

    public List<FullCalculation> getAllCalculationParameters(){
        return profitabilityCalculatorRepository.findAll();
    }

    public FullCalculation getCalculation(Long id){
        return profitabilityCalculatorRepository.findById(id).orElseThrow(() -> new CalculationNotFoundException());
    }

    public FullCalculation saveCalculation(FullCalculation fullCalculation){
        return profitabilityCalculatorRepository.save(fullCalculation);
    }

    public void deleteCalculation(Long id){
        profitabilityCalculatorRepository.deleteById(id);
    }


}
