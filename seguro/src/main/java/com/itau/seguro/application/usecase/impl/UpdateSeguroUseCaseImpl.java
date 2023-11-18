package com.itau.seguro.application.usecase.impl;

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
      return saveOrUpdateSeguroService.saveSeguro(model);
    } catch (Exception e) {
      throw e;
    }
  }
}
