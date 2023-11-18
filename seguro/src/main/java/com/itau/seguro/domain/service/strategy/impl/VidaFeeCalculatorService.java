package com.itau.seguro.domain.service.strategy.impl;

import com.itau.seguro.domain.service.strategy.FeeCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class VidaFeeCalculatorService implements FeeCalculatorService {
  @Override
  public double calculate(double precoBase) {
    var iof = precoBase * 0.01;
    var pis = precoBase * 0.022;
    return iof + pis;
  }
}
