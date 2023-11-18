package com.itau.seguro.application.utils;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricUtils {
  private static Counter counterMetric(String metricName, String description) {
    SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
    return Counter.builder(metricName).description(description).register(meterRegistry);
  }

  public static Counter updateSeguroSucesso() {
    return counterMetric(
        "seguro.atualizacao.sucesso",
        "quantidade de processamento de atualização de seguro bem sucedidas");
  }

  public static Counter updateSeguroInsucesso() {
    return counterMetric(
        "seguro.atualizacao.insucesso",
        "quantidade de processamento de atualização de seguro não bem sucedidas");
  }

  public static Counter calculoTaxaSucesso() {
    return counterMetric(
        "seguro.calculo-taxa.sucesso", "quantidade de cálculo de taxa bem sucedidas");
  }

  public static Counter calculoTaxaInsucesso() {
    return counterMetric(
        "seguro.calculo-taxa.insucesso", "quantidade de cálculo de seguro não bem sucedidas");
  }
}
