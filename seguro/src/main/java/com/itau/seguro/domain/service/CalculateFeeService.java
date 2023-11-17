package com.itau.seguro.domain.service;

import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.service.strategy.FeeCalculatorService;
import com.itau.seguro.domain.usecase.CalculateFeeUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.itau.seguro.domain.service.strategy.mapping.FeeCalculatorMapping.feeCalculator;

@Service
@AllArgsConstructor
@Slf4j
public class CalculateFeeService implements CalculateFeeUseCase {
  @Override
  public Double execute(CategoriaEnum categoria, Double precoBase) {
    var fee = feeCalculator.getOrDefault(categoria, () -> {
      throw new IllegalArgumentException("Categoria nao mapeada para strategy");
    }).get();
    return fee.calculate(precoBase);
  }
}
