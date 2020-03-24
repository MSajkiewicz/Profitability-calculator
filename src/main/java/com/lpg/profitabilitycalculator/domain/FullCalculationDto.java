package com.lpg.profitabilitycalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FullCalculationDto {
    private Long id;
    private double lpgInstalationCost;
    private int distancePerMonth;
    private double bpConsumption;
    private double lpgConsumption;
    private double bpPrice;
    private double lpgPrice;
    private double monthsToFullRefund;
    private double savingsPer100km;
    private double savingsPer1000km;
    private double savingsPerMonth;
}
