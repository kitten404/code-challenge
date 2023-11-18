package com.itau.seguro.mock;

import com.itau.seguro.infrastructure.adapater.rest.dto.enums.CategoriaDtoEnum;
import com.itau.seguro.infrastructure.adapater.rest.dto.request.SeguroV1Request;
import java.util.Random;

public class SeguroV1RequestMock {
  public static SeguroV1Request createSeguroV1RequestMock() {
    var random = new Random();
    return SeguroV1Request.builder()
        .nome("ANY")
        .categoria(CategoriaDtoEnum.AUTO)
        .precoBase(random.nextDouble(100, 9999))
        .build();
  }
}
