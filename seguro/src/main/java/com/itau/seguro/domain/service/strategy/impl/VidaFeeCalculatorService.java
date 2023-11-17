package com.itau.seguro.domain.service.strategy.impl;

import com.itau.seguro.domain.service.strategy.FeeCalculatorService;

public class VidaFeeCalculatorService implements FeeCalculatorService {
  @Override
  public Double calculate(double precoBase) {
    var iof = precoBase * 0.01;
    var pis = precoBase * 0.022;
    return iof + pis;
  }
}
