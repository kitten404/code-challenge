package com.itau.seguro.domain.service;

import static com.itau.seguro.domain.service.strategy.mapping.FeeCalculatorMapping.feeCalculator;

import com.itau.seguro.domain.model.enums.CategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CalculateFeeService {
  public Double calculateFee(CategoriaEnum categoria, Double precoBase) {
    var fee =
        feeCalculator
            .getOrDefault(
                categoria,
                () -> {
                  throw new IllegalArgumentException("Categoria nao mapeada para strategy");
                })
            .get();
    return fee.calculate(precoBase);
  }
}
