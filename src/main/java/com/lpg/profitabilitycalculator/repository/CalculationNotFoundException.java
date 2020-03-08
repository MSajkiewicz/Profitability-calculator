package com.lpg.profitabilitycalculator.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Id is invalid")
public class CalculationNotFoundException extends RuntimeException{

}
