package com.bootcamp.demo.demo_thylemeaf.config;

import com.bootcamp.demo.demo_thylemeaf.controller.CoinController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class RefreshScheduler {

  @Autowired
  private CoinController coinController;

  // @Scheduled(fixedRate = 30000)
  // public void refresh() {
  // coinController.getCoins();
  // }
}
