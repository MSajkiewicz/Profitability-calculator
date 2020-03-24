package com.lpg.profitabilitycalculator.repository;

import com.lpg.profitabilitycalculator.domain.CalcParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private ProfitabilityCalculatorRepository profitabilityCalculatorRepository;

    public List<CalcParams> getAllCalculationParameters(){
        return profitabilityCalculatorRepository.findAll();
    }

    public CalcParams getCalculation(Long id){
        return profitabilityCalculatorRepository.findById(id).orElseThrow(() -> new CalculationNotFoundException());
    }

    public CalcParams saveCalculation(CalcParams calcParams){
        return profitabilityCalculatorRepository.save(calcParams);
    }

    public void deleteCalculation(Long id){
        profitabilityCalculatorRepository.deleteById(id);
    }


}
