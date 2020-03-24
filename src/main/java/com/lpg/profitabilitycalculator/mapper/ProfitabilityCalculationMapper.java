package com.lpg.profitabilitycalculator.mapper;

import com.lpg.profitabilitycalculator.domain.FullCalculation;
import com.lpg.profitabilitycalculator.domain.CalcParamsDTO;
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

    public FullCalculation mapToFullCalculation(CalcParamsDTO calcParamsDTO){
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
                calcService.getMonthsToFullRefund(calcParamsDTO));
    }
    public FullCalculationDto mapToFullCalculationDto(CalcParamsDTO calcParamsDTO) {
        return new FullCalculationDto(
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
