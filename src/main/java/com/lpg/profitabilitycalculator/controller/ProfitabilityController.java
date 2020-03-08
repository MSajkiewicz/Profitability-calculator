package com.lpg.profitabilitycalculator.controller;

import com.lpg.profitabilitycalculator.domain.CalculationParametersDTO;
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
    public List<CalculationParametersDTO> getCalculations(){
        return profitabilityCalculationMapper.mapToCalculationParametersDTOList(dbService.getAllCalculationParameters());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCalculation")
    public CalculationParametersDTO getCalculation(@RequestParam Long id){
        return profitabilityCalculationMapper.mapToCalculationParametersDTO(dbService.getCalculation(id));
    }
    @RequestMapping(method = RequestMethod.POST, value = "createCalculation")
    public void createCalculation(@RequestBody CalculationParametersDTO calculationParametersDTO){
        dbService.saveCalculation(profitabilityCalculationMapper.mapToCalculationParameters(calculationParametersDTO));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateCalculation")
    public CalculationParametersDTO updateCalculation(@RequestBody CalculationParametersDTO calculationParametersDTO){
    return profitabilityCalculationMapper.mapToCalculationParametersDTO(dbService.saveCalculation(profitabilityCalculationMapper.mapToCalculationParameters(calculationParametersDTO)));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCalculation")
    public void deleteCalculation(Long id){
        dbService.deleteCalculation(id);
    }


}
