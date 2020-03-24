package com.lpg.profitabilitycalculator.mapper;

import com.lpg.profitabilitycalculator.domain.CalcParams;
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

    public CalcParams mapToCalculationParameters(CalcParamsDTO calcParamsDTO){
        return new CalcParams(
                calcParamsDTO.getId(),
                calcParamsDTO.getLpgInstalationCost(),
                calcParamsDTO.getDistancePerMonth(),
                calcParamsDTO.getBpConsumption(),
                calcParamsDTO.getLpgConsumption(),
                calcParamsDTO.getBpPrice(),
                calcParamsDTO.getLpgPrice());
    }

    public CalcParamsDTO mapToCalcParamsDTO(CalcParams calcParams){
        return new CalcParamsDTO(
                calcParams.getId(),
                calcParams.getLpgInstalationCost(),
                calcParams.getDistancePerMonth(),
                calcParams.getBpConsumption(),
                calcParams.getLpgConsumption(),
                calcParams.getBpPrice(),
                calcParams.getLpgPrice());
    }

    public List<CalcParamsDTO> mapToCalculationParametersDTOList(final List<CalcParams> calcParamsList) {
        return calcParamsList.stream()
                .map(p -> new CalcParamsDTO(
                        p.getId(),
                        p.getLpgInstalationCost(),
                        p.getDistancePerMonth(),
                        p.getBpConsumption(),
                        p.getLpgConsumption(),
                        p.getBpPrice(),
                        p.getLpgPrice()))
                .collect(Collectors.toList());
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



}
