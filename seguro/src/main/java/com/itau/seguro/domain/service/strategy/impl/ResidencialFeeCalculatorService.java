package com.itau.seguro.domain.service.strategy.impl;

import com.itau.seguro.domain.service.strategy.FeeCalculatorService;

public class ResidencialFeeCalculatorService implements FeeCalculatorService {
  @Override
  public Double calculate(double precoBase) {
    var iof = precoBase * 0.04;
    var confins = precoBase * 0.03;
    return iof + confins;
  }
}
