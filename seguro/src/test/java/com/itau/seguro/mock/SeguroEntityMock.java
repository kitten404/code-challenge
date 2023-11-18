package com.itau.seguro.mock;

import com.itau.seguro.infrastructure.adapater.persistence.entity.SeguroEntity;
import com.itau.seguro.infrastructure.adapater.persistence.entity.enums.CategoriaEntityEnum;
import java.util.Random;
import java.util.UUID;

public class SeguroEntityMock {
  public static SeguroEntity createSeguroEntityMock() {
    var random = new Random();
    return SeguroEntity.builder()
        .id(UUID.randomUUID())
        .nome("ANY")
        .categoria(CategoriaEntityEnum.AUTO)
        .precoBase(random.nextDouble(100, 9999))
        .build();
  }
}
