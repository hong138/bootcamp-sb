package com.bootcamp.demo.demo_thylemeaf.controller;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_thylemeaf.dto.CoinDTO;
import com.bootcamp.demo.demo_thylemeaf.mapper.CoinMapper;
import com.bootcamp.demo.demo_thylemeaf.service.CoinService;

@RestController
public class CoinController {
  @Autowired
  private CoinService coinService;

  @Autowired
  private CoinMapper mapper;

  @GetMapping("/updatecoins")
  public List<CoinDTO> refreshCoins(Model model) {
    List<CoinDTO> coinDTOs = coinService.getCoins().stream()
        .map(e -> this.mapper.map(e)).collect(Collectors.toList());
    System.out.println(coinDTOs);
    return coinDTOs;

  }
}
