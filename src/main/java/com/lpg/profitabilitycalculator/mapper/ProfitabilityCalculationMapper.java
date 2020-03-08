package com.lpg.profitabilitycalculator.mapper;

import com.lpg.profitabilitycalculator.domain.CalculationParameters;
import com.lpg.profitabilitycalculator.domain.CalculationParametersDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfitabilityCalculationMapper {

    public CalculationParameters mapToCalculationParameters(CalculationParametersDTO calculationParametersDTO){
        return new CalculationParameters(
                calculationParametersDTO.getId(),
                calculationParametersDTO.getLpgInstalationCost(),
                calculationParametersDTO.getDistancePerMonth(),
                calculationParametersDTO.getBpConsumption(),
                calculationParametersDTO.getLpgConsumption(),
                calculationParametersDTO.getBpPrice(),
                calculationParametersDTO.getLpgPrice());
    }

    public CalculationParametersDTO mapToCalculationParametersDTO(CalculationParameters calculationParameters){
        return new CalculationParametersDTO(
                calculationParameters.getId(),
                calculationParameters.getLpgInstalationCost(),
                calculationParameters.getDistancePerMonth(),
                calculationParameters.getBpConsumption(),
                calculationParameters.getLpgConsumption(),
                calculationParameters.getBpPrice(),
                calculationParameters.getLpgPrice());
    }

    public List<CalculationParametersDTO> mapToCalculationParametersDTOList(final List<CalculationParameters> calculationParametersList) {
        return calculationParametersList.stream()
                .map(p -> new CalculationParametersDTO(
                        p.getId(),
                        p.getLpgInstalationCost(),
                        p.getDistancePerMonth(),
                        p.getBpConsumption(),
                        p.getLpgConsumption(),
                        p.getBpPrice(),
                        p.getLpgPrice()))
                .collect(Collectors.toList());
    }
}
