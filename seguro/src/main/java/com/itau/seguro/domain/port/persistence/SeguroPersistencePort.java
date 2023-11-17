package com.itau.seguro.domain.port.persistence;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;

public interface SeguroPersistencePort {
  SeguroModel save(SeguroModel model);

  SeguroModel findByNameAndCategoriaAndPrecoBase(String name, CategoriaEnum categoria, Double precoBase);
}
