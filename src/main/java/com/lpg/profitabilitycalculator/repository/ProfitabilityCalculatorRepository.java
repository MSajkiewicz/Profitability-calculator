package com.lpg.profitabilitycalculator.repository;

import com.lpg.profitabilitycalculator.domain.FullCalculation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfitabilityCalculatorRepository extends CrudRepository<FullCalculation, Long>{
    @Override
    List<FullCalculation> findAll();

    @Override
    Optional<FullCalculation> findById(Long id);

    @Override
    FullCalculation save(FullCalculation fullCalculation);

    @Override
    void deleteById(Long id);




}
