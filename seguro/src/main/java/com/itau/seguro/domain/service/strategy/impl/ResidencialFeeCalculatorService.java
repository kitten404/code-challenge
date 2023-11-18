package com.itau.seguro.domain.service.strategy.impl;

import com.itau.seguro.domain.service.strategy.FeeCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class ResidencialFeeCalculatorService implements FeeCalculatorService {
  @Override
  public double calculate(double precoBase) {
    var iof = precoBase * 0.04;
    var confins = precoBase * 0.03;
    return iof + confins;
  }
}
