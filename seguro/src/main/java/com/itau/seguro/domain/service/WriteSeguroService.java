package com.itau.seguro.domain.service;

import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WriteSeguroService {
  private SeguroPersistencePort seguroPersistence;

  public SeguroModel saveSeguro(SeguroModel model) {
    try {
      log.info("m=saveSeguro msg=Início de salvar seguro: {}", model);
      var savedSeguro = seguroPersistence.save(model);
      log.info("m=saveSeguro msg=Final de salvar seguro: {}", model);
      return savedSeguro;
    } catch (Exception e) {
      log.error("m=saveSeguro msg=Erro ao salvar seguro: {}, error: {}", model, e.getMessage());
      throw new PersistenceException("Erro ao salvar seguro " + e);
    }
  }
}
