package com.lpg.profitabilitycalculator.mapper;

import com.lpg.profitabilitycalculator.domain.FullCalculation;
import com.lpg.profitabilitycalculator.domain.CalcParamsDto;
import com.lpg.profitabilitycalculator.domain.FullCalculationDto;
import com.lpg.profitabilitycalculator.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfitabilityCalculationMapper {

    @Autowired
    CalcService calcService;

    public FullCalculation mapToFullCalculation(CalcParamsDto calcParamsDTO){
        return new FullCalculation(
                calcParamsDTO.getId(),
                calcParamsDTO.getLpgInstalationCost(),
                calcParamsDTO.getDistancePerMonth(),
                calcParamsDTO.getBpConsumption(),
                calcParamsDTO.getLpgConsumption(),
                calcParamsDTO.getBpPrice(),
                calcParamsDTO.getLpgPrice(),
                calcService.getMonthsToFullRefund(calcParamsDTO),
                calcService.getSavingsPer100km(calcParamsDTO),
                calcService.getSavingsPer1000km(calcParamsDTO),
                calcService.getSavingsPerMonth(calcParamsDTO));
    }
    public FullCalculationDto mapToFullCalculationDto(FullCalculation fullCalculation) {
        return new FullCalculationDto(
                fullCalculation.getId(),
                fullCalculation.getLpgInstalationCost(),
                fullCalculation.getDistancePerMonth(),
                fullCalculation.getBpConsumption(),
                fullCalculation.getLpgConsumption(),
                fullCalculation.getBpPrice(),
                fullCalculation.getLpgPrice(),
                fullCalculation.getMonthsToFullRefund(),
                fullCalculation.getSavingsPer100km(),
                fullCalculation.getSavingsPer1000km(),
                fullCalculation.getSavingsPerMonth());
    }

    public List<FullCalculationDto> mapToFullCalculationDTOList(final List<FullCalculation> fullCalculationList) {
        return fullCalculationList.stream()
                .map(p -> new FullCalculationDto(
                        p.getId(),
                        p.getLpgInstalationCost(),
                        p.getDistancePerMonth(),
                        p.getBpConsumption(),
                        p.getLpgConsumption(),
                        p.getBpPrice(),
                        p.getLpgPrice(),
                        p.getMonthsToFullRefund(),
                        p.getSavingsPer100km(),
                        p.getSavingsPer1000km(),
                        p.getSavingsPerMonth()))
                .collect(Collectors.toList());
    }





}
