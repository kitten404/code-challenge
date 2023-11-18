package com.itau.seguro.domain.service;

import com.itau.seguro.domain.model.SeguroModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SaveOrUpdateSeguroService {
  private FindSeguroService findSeguroService;
  private WriteSeguroService writeSeguroService;
  private CalculateFeeService calculateFeeService;

  public SeguroModel saveSeguro(SeguroModel model) {
    try {
      var seguro =
          findSeguroService.findSeguro(model.getNome(), model.getCategoria(), model.getPrecoBase());
      if (seguro == null) {
        seguro = model;
      }
      var fee = calculateFeeService.calculateFee(seguro.getCategoria(), seguro.getPrecoBase());

      seguro.setPrecoTarifado(seguro.getPrecoBase() + fee);
      return writeSeguroService.execute(seguro);
    } catch (Exception e) {
      log.error("Nao foi possível salvar seguro: ", e.getMessage());
      throw e;
    }
  }
}
