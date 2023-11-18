package com.itau.seguro.application.usecase;

import com.itau.seguro.domain.model.SeguroModel;

public interface UpdateSeguroUseCase {
  SeguroModel execute(SeguroModel model);
}
