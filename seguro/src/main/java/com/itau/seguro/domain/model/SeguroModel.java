package com.itau.seguro.domain.model;

import com.itau.seguro.domain.model.enums.CategoriaEnum;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeguroModel {
  private UUID id;
  private String nome;
  private CategoriaEnum categoria;
  private double precoBase;
  private double precoTarifado;
}
