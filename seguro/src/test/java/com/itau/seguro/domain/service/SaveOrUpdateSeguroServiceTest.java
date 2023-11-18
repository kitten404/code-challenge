package com.itau.seguro.domain.service;

import static com.itau.seguro.mock.SeguroModelMock.createSeguroModelMock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.itau.seguro.UnitTests;
import com.itau.seguro.domain.exception.PersistenceException;
import com.itau.seguro.domain.model.SeguroModel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SaveOrUpdateSeguroServiceTest extends UnitTests {

  @Mock private FindSeguroService findSeguroService;

  @Mock private WriteSeguroService writeSeguroService;

  @Mock private CalculateFeeService calculateFeeService;

  @InjectMocks private SaveOrUpdateSeguroService saveOrUpdateSeguroService;

  @Test
  void DeveSalvarSeguroQuandoNaoExistirComSucesso() {
    var seguroModel = createSeguroModelMock();

    when(findSeguroService.findSeguro(
            seguroModel.getNome(), seguroModel.getCategoria(), seguroModel.getPrecoBase()))
        .thenReturn(null);

    double fee = 20.0;
    when(calculateFeeService.calculateFee(seguroModel.getCategoria(), seguroModel.getPrecoBase()))
        .thenReturn(fee);

    when(writeSeguroService.saveSeguro(any(SeguroModel.class))).thenReturn(seguroModel);

    SeguroModel actualSavedSeguro = saveOrUpdateSeguroService.saveOrUpdateSeguro(seguroModel);

    assertNotNull(actualSavedSeguro);

    verify(findSeguroService)
        .findSeguro(seguroModel.getNome(), seguroModel.getCategoria(), seguroModel.getPrecoBase());
    verify(calculateFeeService)
        .calculateFee(seguroModel.getCategoria(), seguroModel.getPrecoBase());

    verify(writeSeguroService)
        .saveSeguro(argThat(argument -> argument.getNome().equals(seguroModel.getNome())));
  }

  @Test
  void DeveSalvarSeguroQuandoJaExistir() {
    var seguroModel = createSeguroModelMock();

    when(findSeguroService.findSeguro(
            seguroModel.getNome(), seguroModel.getCategoria(), seguroModel.getPrecoBase()))
        .thenReturn(seguroModel);

    double fee = 20.0;
    when(calculateFeeService.calculateFee(seguroModel.getCategoria(), seguroModel.getPrecoBase()))
        .thenReturn(fee);

    when(writeSeguroService.saveSeguro(any(SeguroModel.class))).thenReturn(seguroModel);

    var result = saveOrUpdateSeguroService.saveOrUpdateSeguro(seguroModel);

    assertNotNull(result);

    verify(findSeguroService)
        .findSeguro(seguroModel.getNome(), seguroModel.getCategoria(), seguroModel.getPrecoBase());
    verify(calculateFeeService)
        .calculateFee(seguroModel.getCategoria(), seguroModel.getPrecoBase());

    verify(writeSeguroService)
        .saveSeguro(argThat(argument -> argument.getNome().equals(seguroModel.getNome())));
  }

  @Test
  void deveDarExceptionQuandoFindSeguroPersistenceFalhar() {
    var seguroModel = createSeguroModelMock();

    when(findSeguroService.findSeguro(
            seguroModel.getNome(), seguroModel.getCategoria(), seguroModel.getPrecoBase()))
        .thenThrow(new RuntimeException("Some error"));

    assertThrows(
        PersistenceException.class,
        () -> saveOrUpdateSeguroService.saveOrUpdateSeguro(seguroModel));
  }
}
