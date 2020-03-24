package com.lpg.profitabilitycalculator.service;

import com.lpg.profitabilitycalculator.domain.CalcParamsDto;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public double getSavingsPer100km(CalcParamsDto c){
        return (c.getBpConsumption()*c.getBpPrice())-
                (c.getLpgConsumption()*c.getLpgPrice());
    }
    public double getSavingsPer1000km(CalcParamsDto c){
        return getSavingsPer100km(c)*10;
    }
    public double getSavingsPerMonth(CalcParamsDto c){
        return c.getDistancePerMonth()*getSavingsPer100km(c)/100;
    }
    public double getMonthsToFullRefund(CalcParamsDto c){
        return c.getLpgInstalationCost()/getSavingsPerMonth(c);
    }

}
