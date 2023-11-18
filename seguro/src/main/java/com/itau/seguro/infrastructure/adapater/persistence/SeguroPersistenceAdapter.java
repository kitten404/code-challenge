package com.itau.seguro.infrastructure.adapater.persistence;

import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.domain.port.persistence.SeguroPersistencePort;
import com.itau.seguro.infrastructure.adapater.persistence.entity.SeguroEntity;
import com.itau.seguro.infrastructure.adapater.persistence.entity.enums.CategoriaEntityEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class SeguroPersistenceAdapter implements SeguroPersistencePort {
  private SeguroRepository seguroRepository;
  private ModelMapper modelMapper;

  @Override
  public SeguroModel save(SeguroModel model) {
    var seguroEntity = modelMapper.map(model, SeguroEntity.class);
    if (seguroEntity != null) {
      return modelMapper.map(seguroRepository.save(seguroEntity), SeguroModel.class);
    }
    return null;
  }

  @Override
  public SeguroModel findByNameAndCategoriaAndPrecoBase(
      String name, CategoriaEnum categoria, Double precoBase) {
    var seguroEntity =
        seguroRepository.findByNameAndCategoriaAndPrecoBase(
            name, CategoriaEntityEnum.valueOf(categoria.name()), precoBase);
    if (seguroEntity != null) {
      return modelMapper.map(seguroEntity, SeguroModel.class);
    }
    return null;
  }
}
