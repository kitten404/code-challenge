package com.itau.seguro.domain.service;

import static com.itau.seguro.domain.model.enums.CategoriaEnum.*;
import static org.junit.jupiter.api.Assertions.*;

import com.itau.seguro.domain.model.enums.CategoriaEnum;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculateFeeServiceTest {
  private CalculateFeeService calculateFeeService;

  @BeforeEach
  void setUp() {
    calculateFeeService = new CalculateFeeService();
  }

  @ParameterizedTest
  @MethodSource("argumentosTaxas")
  void deveCalcularTaxasComSucesso(
      CategoriaEnum categoria, double precoBase, double valorEsperado) {

    var result = calculateFeeService.calculateFee(categoria, precoBase);

    assertEquals(valorEsperado, result);
  }

  private static Stream<Arguments> argumentosTaxas() {
    return Stream.of(
        Arguments.of(AUTO, 100, 10.5),
        Arguments.of(VIDA, 100, 3.2),
        Arguments.of(VIAGEM, 100, 7.0),
        Arguments.of(PATRIMONIAL, 100, 8.0));
  }
}
