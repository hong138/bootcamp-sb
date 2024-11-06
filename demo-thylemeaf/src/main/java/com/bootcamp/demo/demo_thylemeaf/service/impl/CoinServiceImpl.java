package com.bootcamp.demo.demo_thylemeaf.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_thylemeaf.model.dto.CryptoCoin;
import com.bootcamp.demo.demo_thylemeaf.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService {
  private static final String coinUrl =
      "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd&x-cg-demo-api-key=CG-jntpA2YLSKKXajYfHwZraWwg";

  @Autowired
  private RestTemplate restTemplate = new RestTemplate();

  @Override
  public List<CryptoCoin> getCoins() {
    return Arrays
        .asList(restTemplate.getForObject(coinUrl, CryptoCoin[].class));
  }

}
