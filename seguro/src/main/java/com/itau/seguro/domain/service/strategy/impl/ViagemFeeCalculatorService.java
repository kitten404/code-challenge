package com.itau.seguro.domain.service.strategy.impl;

import com.itau.seguro.domain.service.strategy.FeeCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class ViagemFeeCalculatorService implements FeeCalculatorService {
  @Override
  public double calculate(double precoBase) {
    var iof = precoBase * 0.02;
    var pis = precoBase * 0.04;
    var confins = precoBase * 0.01;
    return iof + pis + confins;
  }
}
