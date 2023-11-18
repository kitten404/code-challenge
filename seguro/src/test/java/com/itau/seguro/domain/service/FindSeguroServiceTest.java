package com.itau.seguro.domain.service;

import static com.itau.seguro.mock.SeguroModelMock.createSeguroModelMock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.itau.seguro.UnitTests;
import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class FindSeguroServiceTest extends UnitTests {

  @Mock private SeguroPersistencePort persistencePort;

  @InjectMocks private FindSeguroService findSeguroService;

  @Test
  void deveEncontrarSeguroPorNomeCategoriaEPrecoComSucesso() {

    var seguroEsperado = createSeguroModelMock();

    when(persistencePort.findByNameAndCategoriaAndPrecoBase(any(), any(), any()))
        .thenReturn(seguroEsperado);

    var seguroEncontrado = findSeguroService.findSeguro("nome", CategoriaEnum.AUTO, 400.0);

    assertNotNull(seguroEncontrado);
    assertEquals(seguroEsperado, seguroEncontrado);

    verify(persistencePort).findByNameAndCategoriaAndPrecoBase(any(), any(), any());
  }

  @Test
  void deveDarExceptionQuandoPersistenceFalhar() {
    when(persistencePort.findByNameAndCategoriaAndPrecoBase(any(), any(), any()))
        .thenThrow(new RuntimeException("Some error"));

    assertThrows(
        PersistenceException.class,
        () -> findSeguroService.findSeguro("nome", CategoriaEnum.AUTO, 400.0));
  }
}
