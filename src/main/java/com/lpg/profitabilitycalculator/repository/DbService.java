package com.lpg.profitabilitycalculator.repository;

import com.lpg.profitabilitycalculator.domain.CalculationParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private ProfitabilityCalculatorRepository profitabilityCalculatorRepository;

    public List<CalculationParameters> getAllCalculationParameters(){
        return profitabilityCalculatorRepository.findAll();
    }

    public CalculationParameters getCalculation(Long id){
        return profitabilityCalculatorRepository.findById(id).orElseThrow(() -> new CalculationNotFoundException());
    }

    public CalculationParameters saveCalculation(CalculationParameters calculationParameters){
        return profitabilityCalculatorRepository.save(calculationParameters);
    }

    public void deleteCalculation(Long id){
        profitabilityCalculatorRepository.deleteById(id);
    }


}
