package com.bootcamp.demo.demo_thylemeaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class CoinDTO {
  private String id;
  private String image;
  private Double currentPrice;
}
