package com.itau.seguro.domain.usecase;

import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.service.strategy.FeeCalculatorService;

public interface CalculateFeeUseCase {
  Double execute(CategoriaEnum categoria, Double precoBase);
}
