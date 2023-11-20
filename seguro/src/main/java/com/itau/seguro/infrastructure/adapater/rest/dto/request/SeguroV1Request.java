package com.itau.seguro.infrastructure.adapater.rest.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.itau.seguro.infrastructure.adapater.rest.dto.enums.CategoriaDtoEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SeguroV1Request {
  @NotNull(message = "nome não pode ser nulo")
  @NotEmpty(message = "nome não pode ser vazio")
  private String nome;

  @NotNull(message = "categoria não pode ser nulo")
  private CategoriaDtoEnum categoria;

  @NotNull(message = "preco_base não pode ser nulo")
  private double precoBase;
}
