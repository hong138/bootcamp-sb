package com.bootcamp.demo.demo_thylemeaf.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_thylemeaf.dto.CoinDTO;
import com.bootcamp.demo.demo_thylemeaf.model.dto.CryptoCoin;

@Component
public class CoinMapper {
  public CoinDTO map(CryptoCoin coin) {
    return CoinDTO.builder().id(coin.getId()).image(coin.getImage())
        .currentPrice(coin.getCurrentPrice()).build();
  }

}
