package com.itau.seguro.application.usecase.impl;

import static com.itau.seguro.mock.SeguroModelMock.createSeguroModelMock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.itau.seguro.UnitTests;
import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.service.SaveOrUpdateSeguroService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class UpdateSeguroUseCaseImplTest extends UnitTests {
  @Mock private SaveOrUpdateSeguroService saveOrUpdateSeguroService;
  @InjectMocks private UpdateSeguroUseCaseImpl updateSeguroUseCase;

  @Test
  public void deveSalavarOuAlterarSeguroComSucesso() {
    var seguroEsperado = createSeguroModelMock();

    when(saveOrUpdateSeguroService.saveOrUpdateSeguro(seguroEsperado)).thenReturn(seguroEsperado);

    SeguroModel result = updateSeguroUseCase.execute(seguroEsperado);

    assertNotNull(result);
    verify(saveOrUpdateSeguroService, times(1)).saveOrUpdateSeguro(seguroEsperado);
  }

  @Test
  public void deveDarExceptionQuandoOSerivcoDeUpdateFalhar() {
    var seguroEsperado = createSeguroModelMock();

    when(saveOrUpdateSeguroService.saveOrUpdateSeguro(seguroEsperado))
        .thenThrow(new PersistenceException("Test Exception"));

    assertThrows(PersistenceException.class, () -> updateSeguroUseCase.execute(seguroEsperado));
  }
}
