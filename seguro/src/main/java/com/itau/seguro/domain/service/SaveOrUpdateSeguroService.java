package com.itau.seguro.domain.service;

import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.model.SeguroModel;
import java.util.UUID;
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

  public SeguroModel saveOrUpdateSeguro(SeguroModel model) {
    try {
      log.info("m=saveSeguro msg=Início de salvar ou atualizar seguro: {}", model);
      var seguro =
          findSeguroService.findSeguro(model.getNome(), model.getCategoria(), model.getPrecoBase());
      if (seguro == null) {
        seguro = model;
      }
      var fee = calculateFeeService.calculateFee(seguro.getCategoria(), seguro.getPrecoBase());

      seguro.setPrecoTarifado(seguro.getPrecoBase() + fee);
      seguro.setId(UUID.randomUUID());
      var savedSeguro = writeSeguroService.saveSeguro(seguro);
      log.info("m=saveSeguro msg=Final de salvar ou atualizar: {}", model);
      return savedSeguro;
    } catch (Exception e) {
      log.error("m=saveSeguro msg=Erro ao salvar seguro :{}, error: ", model, e.getMessage());
      throw new PersistenceException("Erro ao salvar ou atualizar seguro " + e);
    }
  }
}
