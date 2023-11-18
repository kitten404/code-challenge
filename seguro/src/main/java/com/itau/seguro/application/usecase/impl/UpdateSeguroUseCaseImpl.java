package com.itau.seguro.application.usecase.impl;

import static com.itau.seguro.application.utils.MetricUtils.updateSeguroInsucesso;
import static com.itau.seguro.application.utils.MetricUtils.updateSeguroSucesso;

import com.itau.seguro.application.usecase.UpdateSeguroUseCase;
import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.service.SaveOrUpdateSeguroService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class UpdateSeguroUseCaseImpl implements UpdateSeguroUseCase {
  private SaveOrUpdateSeguroService saveOrUpdateSeguroService;

  @Override
  public SeguroModel execute(SeguroModel model) {
    try {
      log.info("m=UpdateSeguroUseCaseImpl.execute msg=Início de atualização de seguro {}", model);
      var savedSeguro = saveOrUpdateSeguroService.saveOrUpdateSeguro(model);
      log.info("m=UpdateSeguroUseCaseImpl.execute msg=Final de atualização de seguro: {}", model);
      updateSeguroSucesso().increment();
      return savedSeguro;
    } catch (Exception e) {
      log.error(
          "m=UpdateSeguroUseCaseImpl.execute msg=Erro ao processar atualizacao de seguro: {}, error: {}",
          model,
          e.getMessage());
      updateSeguroInsucesso().increment();
      throw e;
    }
  }
}
