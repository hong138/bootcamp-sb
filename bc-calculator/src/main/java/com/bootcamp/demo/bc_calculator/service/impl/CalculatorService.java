package com.bootcamp.demo.bc_calculator.service;

import java.math.BigDecimal;
import java.rmi.server.Operation;

import com.bootcamp.demo.bc_calculator.model.CalculateResponse;

public interface CalculatorService {
  CalculateResponse calculate(BigDecimal.valueOf(Long.valueOf(x)), BigDecimal y, Operation.valueOf(operation));
}
