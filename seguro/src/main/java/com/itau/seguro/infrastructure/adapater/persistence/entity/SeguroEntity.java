package com.itau.seguro.infrastructure.adapater.persistence.entity;

import com.itau.seguro.infrastructure.adapater.persistence.entity.enums.CategoriaEntityEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Seguro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeguroEntity {
  @Id private UUID id;
  private String nome;
  private CategoriaEntityEnum categoria;

  @Column(name = "preco_base")
  private double precoBase;

  @Column(name = "preco_tarifado")
  private double precoTarifado;
}
