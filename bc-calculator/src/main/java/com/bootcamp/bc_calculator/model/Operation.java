package com.bootcamp.bc_calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.bootcamp.bc_calculator.exception.CannotDivideZeroException;

import lombok.Getter;

@Getter
public enum Operation {
  ADD("add"),
  SUBTRACT("sub"),
  MULTIPLY("mul"),
  DIVIDE("div");

  private String operation;

  private Operation(String operation) {
    this.operation = operation;
  }

  private String calculate(BigDecimal x, BigDecimal y, Operation operation){
    switch (this){
      case ADD -> x.add(y).setScale(5).toString();
      case SUBTRACT -> x.subtract(y).setScale(5).toString();
      case MULTIPLY -> x.multiply(y).setScale(5).toString();
      case DIVIDE -> {
        if (y.equals(BigDecimal.ZERO)) {
          throw new CannotDivideZeroException("y cannot be zero");
        }
        yield x.divide(y).setScale(5).toString();
      }
    default throw new IllegalArgumentException("Invalid operation: " + operation);
    }
  }
}

