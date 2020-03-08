package com.lpg.profitabilitycalculator.repository;

import com.lpg.profitabilitycalculator.domain.CalculationParameters;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfitabilityCalculatorRepository extends CrudRepository<CalculationParameters, Long>{
    @Override
    List<CalculationParameters> findAll();

    @Override
    Optional<CalculationParameters> findById(Long id);

    @Override
    CalculationParameters save(CalculationParameters calculationParameters);

    @Override
    void deleteById(Long id);




}
