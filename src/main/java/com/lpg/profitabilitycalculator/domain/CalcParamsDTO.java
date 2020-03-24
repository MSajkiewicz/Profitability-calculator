package com.lpg.profitabilitycalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CalcParamsDTO {
    private Long id;
    private double lpgInstalationCost;
    private int distancePerMonth;
    private double bpConsumption;
    private double lpgConsumption;
    private double bpPrice;
    private double lpgPrice;
}
