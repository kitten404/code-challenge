package com.itau.seguro.mock;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import java.util.Random;
import java.util.UUID;

public class SeguroModelMock {
  public static SeguroModel createSeguroModelMock() {
    var random = new Random();
    return SeguroModel.builder()
        .id(UUID.randomUUID())
        .nome("ANY")
        .categoria(CategoriaEnum.AUTO)
        .precoBase(random.nextDouble(100, 9999))
        .build();
  }
}
