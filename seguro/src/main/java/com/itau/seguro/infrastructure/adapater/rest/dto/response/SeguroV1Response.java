package com.itau.seguro.infrastructure.adapater.rest.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.itau.seguro.infrastructure.adapater.rest.dto.enums.CategoriaDtoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SeguroV1Response {
  private String nome;
  private CategoriaDtoEnum categoria;
  private double precoBase;
  private double precoTarifado;
}
