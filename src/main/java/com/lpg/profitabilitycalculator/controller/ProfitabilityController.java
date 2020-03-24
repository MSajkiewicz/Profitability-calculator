package com.lpg.profitabilitycalculator.controller;

import com.lpg.profitabilitycalculator.domain.CalcParamsDTO;
import com.lpg.profitabilitycalculator.domain.FullCalculationDto;
import com.lpg.profitabilitycalculator.mapper.ProfitabilityCalculationMapper;
import com.lpg.profitabilitycalculator.repository.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profitability")
public class ProfitabilityController {

    @Autowired
    ProfitabilityCalculationMapper profitabilityCalculationMapper;
    @Autowired
    DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "getCalculations")
    public List<CalcParamsDTO> getCalculations(){
        return profitabilityCalculationMapper.mapToCalculationParametersDTOList(dbService.getAllCalculationParameters());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCalculation")
    public CalcParamsDTO getCalculation(@RequestParam Long id){
        return profitabilityCalculationMapper.mapToCalcParamsDTO(dbService.getCalculation(id));
    }
    @RequestMapping(method = RequestMethod.POST, value = "createCalculation")
    public FullCalculationDto createCalculation(@RequestBody CalcParamsDTO calcParamsDTO){
       return profitabilityCalculationMapper.mapToFullCalculationDto(calcParamsDTO);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateCalculation")
    public CalcParamsDTO updateCalculation(@RequestBody CalcParamsDTO calcParamsDTO){
    return profitabilityCalculationMapper.mapToCalcParamsDTO(dbService.saveCalculation(profitabilityCalculationMapper.mapToCalculationParameters(calcParamsDTO)));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCalculation")
    public void deleteCalculation(Long id){
        dbService.deleteCalculation(id);
    }


}
