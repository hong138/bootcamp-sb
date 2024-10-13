package com.bootcamp.bc_calculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bootcamp.bc_calculator.exception.CalculateException;
import com.bootcamp.bc_calculator.model.CalculateResponse;
import com.bootcamp.bc_calculator.model.Operation;

@Service
public class CalculatorService {
  public CalculateResponse calculate(BigDecimal x, BigDecimal y, String operation){
    Operation operator = this.map(operation);
    return CalculateResponse.builder()
           .x(String.valueOf(x))
           .y(String.valueOf(y))
           .operation(operator.name())
           .result(operator.calculate(x, y))
           .build();
  }

  public CalculateResponse calculate2(BigDecimal x, BigDecimal y, String operation){
    Operation operator = this.map(operation);
    return CalculateResponse.builder()
           .x(String.valueOf(x))
           .y(String.valueOf(y))
           .operation(operator.name())
           .result(operator.calculate(x, y))
           .build();
  }

  private Operation map(String operation) {
    for (Operation op : Operation.values()){
      if (op.getOperator().equals(operation)){
        return op;
      }
    }
    throw new CalculateException("Illegal input operator");
  }
}
