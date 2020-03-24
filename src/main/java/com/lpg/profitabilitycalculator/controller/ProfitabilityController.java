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
    public List<FullCalculationDto> getCalculations(){
        return profitabilityCalculationMapper.mapToFullCalculationDTOList(dbService.getAllCalculationParameters());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getCalculation")
    public FullCalculationDto getCalculation(@RequestParam Long id){
        return profitabilityCalculationMapper.mapToFullCalculationDto(dbService.getCalculation(id));
    }
    @RequestMapping(method = RequestMethod.POST, value = "createCalculation")
    public void createCalculation(@RequestBody CalcParamsDTO calcParamsDTO){
         dbService.saveCalculation(profitabilityCalculationMapper.mapToFullCalculation(calcParamsDTO));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateCalculation")
    public FullCalculationDto updateCalculation(@RequestBody CalcParamsDTO calcParamsDTO){
        return profitabilityCalculationMapper.mapToFullCalculationDto(dbService.saveCalculation(profitabilityCalculationMapper.mapToFullCalculation(calcParamsDTO)));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCalculation")
    public void deleteCalculation(Long id){
        dbService.deleteCalculation(id);
    }


}
