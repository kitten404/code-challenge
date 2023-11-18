package com.itau.seguro.domain.service;

import com.itau.seguro.domain.exception.PersistenceException;
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
      log.info(
          "m=findSeguro msg=Iníco de encontrar seguro com nome: {}, categoria: {}, and preço base: {}",
          nome,
          categoria.name(),
          precoBase);
      var savedSeguro =
          persistencePort.findByNameAndCategoriaAndPrecoBase(nome, categoria, precoBase);
      log.info(
          "m=findSeguro msg=Final de encontrar seguro com nome: {}, categoria: {}, and preço base: {}",
          nome,
          categoria.name(),
          precoBase);
      return savedSeguro;
    } catch (Exception e) {
      log.error(
          "m=findSeguro msg=Erro ao encontrar seguro com nome: {}, categoria: {}, and preço: {}, error: {}",
          nome,
          categoria.name(),
          precoBase,
          e.getMessage());
      throw new PersistenceException("Erro ao encontrar seguro " + e);
    }
  }
}
