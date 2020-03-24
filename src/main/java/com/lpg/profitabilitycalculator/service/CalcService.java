package com.lpg.profitabilitycalculator.service;

import com.lpg.profitabilitycalculator.domain.CalcParams;
import com.lpg.profitabilitycalculator.domain.CalcParamsDTO;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public double getSavingsPer100km(CalcParamsDTO c){
        return (c.getBpConsumption()*c.getBpPrice())-
                (c.getLpgConsumption()*c.getLpgPrice());
    }
    public double getSavingsPer1000km(CalcParamsDTO c){
        return getSavingsPer100km(c)*10;
    }
    public double getSavingsPerMonth(CalcParamsDTO c){
        return c.getDistancePerMonth()*getSavingsPer100km(c)/100;
    }
    public double getMonthsToFullRefund(CalcParamsDTO c){
        return c.getLpgInstalationCost()/getSavingsPerMonth(c);
    }

}
