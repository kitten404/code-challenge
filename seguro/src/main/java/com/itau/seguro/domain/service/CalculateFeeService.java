package com.itau.seguro.domain.service;

import static com.itau.seguro.domain.service.strategy.mapping.FeeCalculatorMapping.feeCalculator;

import com.itau.seguro.domain.exception.CalculateFeeException;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CalculateFeeService {
  public Double calculateFee(CategoriaEnum categoria, Double precoBase) {
    try {
      var fee =
          feeCalculator
              .getOrDefault(
                  categoria,
                  () -> {
                    throw new IllegalArgumentException("Categoria nao mapeada para strategy");
                  })
              .get();
      var result = fee.calculate(precoBase);
      log.info(
          "m=calculateFee msg=Calculo de tarifa para categoria: {} e preco base: {} = {}",
          categoria.name(),
          precoBase,
          result);

      return result;
    } catch (Exception e) {
      log.error(
          "m=calculateFee msg=Erro no calcula de tarifa para categoria: {} e preco base: {}, error: {}",
          categoria.name(),
          precoBase,
          e.getMessage());
      throw new CalculateFeeException("Erro a calcular tatifa " + e);
    }
  }
}
