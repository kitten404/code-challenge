package com.itau.seguro.domain.usecase;

import com.itau.seguro.domain.model.SeguroModel;

public interface WriteSeguroUseCase {
  SeguroModel execute(SeguroModel model);
}
