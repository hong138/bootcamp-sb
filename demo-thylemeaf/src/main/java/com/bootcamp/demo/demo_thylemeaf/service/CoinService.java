package com.bootcamp.demo.demo_thylemeaf.service;

import java.util.List;
import com.bootcamp.demo.demo_thylemeaf.model.dto.CryptoCoin;

public interface CoinService {

  List<CryptoCoin> getCoins();

}
