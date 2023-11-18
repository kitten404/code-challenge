package com.itau.seguro.infrastructure.adapater.rest.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SeguroV1Response {
  private String nome;
  private CategoriaEnum categoria;
  private Double precoBase;
  private Double precoTarifado;
}
