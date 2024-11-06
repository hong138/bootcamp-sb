package com.bootcamp.demo.demo_thylemeaf.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CryptoCoin {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private double currentPrice;
  private long marketCap;
  private int marketCapRank;
  private long fullyDilutedValuation;
  private double totalVolume;
  private double high24h;
  private double low24h;
  private double priceChange24h;
  private double priceChangePercentage_24h;
  private double marketCapChange24h;
  private double marketCapChangePercentage_24h;
  private double circulatingSupply;
  private double totalSupply;
  private double maxSupply;
  private double ath;
  private double athChangePercentage;
  private String athDate;
  private double atl;
  private double atlChangePercentage;
  private String atlDate;
  private ROI roi;
  private String lastUpdated;

  @Getter
  public static class ROI {
    private double times;
    private String currency;
    private double percentage;
  }
}
