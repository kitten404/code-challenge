package com.itau.seguro.domain.service;

import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import com.itau.seguro.domain.usecase.WriteSeguroUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WriteSeguroService implements WriteSeguroUseCase {
  private SeguroPersistencePort seguroPersistence;

  @Override
  public SeguroModel execute(SeguroModel model) {
    try {
      return seguroPersistence.save(model);
    } catch (Exception e) {
      log.error("m=WriteSeguroService.write msg=Nao foi possivel salvar seguro", e.getMessage());
      throw new PersistenceException();
    }
  }
}
