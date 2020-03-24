package com.lpg.profitabilitycalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "calculation")
public class FullCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LPG_INSTALATION_COST")
    private double lpgInstalationCost;

    @Column(name = "DISTANCE_PER_MONTH")
    private int distancePerMonth;

    @Column(name = "BP_CONSUMPTION")
    private double bpConsumption;

    @Column(name = "LPG_CONSUMPTION")
    private double lpgConsumption;

    @Column(name = "BP_PRICE")
    private double bpPrice;

    @Column(name = "LPG_PRICE")
    private double lpgPrice;

    @Column(name = "MONTHS_TO_FULL_REFUND")
    private double monthsToFullRefund;

    @Column(name = "SAVINGS_PER_100_KM")
    private double savingsPer100km;

    @Column(name = "SAVINGS_PER_1000_KM")
    private double savingsPer1000km;

    @Column(name = "SAVINGS_PER_MONTH")
    private double savingsPerMonth;
}
