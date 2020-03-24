package com.lpg.profitabilitycalculator.repository;

import com.lpg.profitabilitycalculator.domain.CalcParams;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProfitabilityCalculatorRepository extends CrudRepository<CalcParams, Long>{
    @Override
    List<CalcParams> findAll();

    @Override
    Optional<CalcParams> findById(Long id);

    @Override
    CalcParams save(CalcParams calcParams);

    @Override
    void deleteById(Long id);




}
