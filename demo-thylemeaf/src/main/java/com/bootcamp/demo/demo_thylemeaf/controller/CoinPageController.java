package com.bootcamp.demo.demo_thylemeaf.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.bootcamp.demo.demo_thylemeaf.dto.CoinDTO;
import com.bootcamp.demo.demo_thylemeaf.mapper.CoinMapper;
import com.bootcamp.demo.demo_thylemeaf.service.CoinService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoinPageController {
  @Autowired
  private CoinService coinService;

  @Autowired
  private CoinMapper mapper;

  @GetMapping("/coins")
  public String getCoins(Model model) {
    List<CoinDTO> coinDTOs = coinService.getCoins().stream()
        .map(e -> this.mapper.map(e)).collect(Collectors.toList());
    System.out.println(coinDTOs);
    model.addAttribute("coins", coinDTOs);
    return "coins";
  }

}
