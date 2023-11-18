package com.itau.seguro.infrastructure.adapater.persistence;

import com.itau.seguro.infrastructure.adapater.persistence.entity.SeguroEntity;
import com.itau.seguro.infrastructure.adapater.persistence.entity.enums.CategoriaEntityEnum;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<SeguroEntity, UUID> {
  SeguroEntity save(SeguroEntity entity);

  SeguroEntity findByNameAndCategoriaAndPrecoBase(
      String name, CategoriaEntityEnum categoria, Double precoBase);
}
