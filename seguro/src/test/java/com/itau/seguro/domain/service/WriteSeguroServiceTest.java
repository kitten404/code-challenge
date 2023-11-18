package com.itau.seguro.domain.service;

import static com.itau.seguro.mock.SeguroModelMock.createSeguroModelMock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.itau.seguro.UnitTests;
import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class WriteSeguroServiceTest extends UnitTests {
  @Mock private SeguroPersistencePort seguroPersistence;

  @InjectMocks private WriteSeguroService writeSeguroService;

  @Test
  void deveSalvarSeguroComSucesso() {
    var seguroModel = createSeguroModelMock();

    when(seguroPersistence.save(seguroModel)).thenReturn(seguroModel);

    var result = writeSeguroService.saveSeguro(seguroModel);

    assertNotNull(result);

    verify(seguroPersistence).save(seguroModel);
  }

  @Test
  void deveDarExceptionQuandoSalvarPersistenceFalhar() {
    var seguroModel = createSeguroModelMock();

    when(seguroPersistence.save(seguroModel)).thenThrow(new RuntimeException("Some error"));

    assertThrows(PersistenceException.class, () -> writeSeguroService.saveSeguro(seguroModel));
  }
}
