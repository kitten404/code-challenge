package com.itau.seguro.domain.service;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FindSeguroService {
  private SeguroPersistencePort persistencePort;

  public SeguroModel findSeguro(String nome, CategoriaEnum categoria, Double precoBase) {
    try {
      return persistencePort.findByNameAndCategoriaAndPrecoBase(nome, categoria, precoBase);
    } catch (Exception e) {
      throw e;
    }
  }
}
