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
    log.info("m=save msg=Início de save adapter seguro: {}", model);
    var seguroEntity = modelMapper.map(model, SeguroEntity.class);
    var savedObj = modelMapper.map(seguroRepository.save(seguroEntity), SeguroModel.class);
    log.info("m=save msg=Final de save adapter seguro: {}", model);
    return savedObj;
  }

  @Override
  public SeguroModel findByNameAndCategoriaAndPrecoBase(
      String nome, CategoriaEnum categoria, Double precoBase) {
    log.info(
        "m=findByNameAndCategoriaAndPrecoBase msg=Início de encontrar seguro por nome: {}, categoria: {} e preço base: {}",
        nome,
        categoria.name(),
        precoBase);
    var seguroEntity =
        seguroRepository.findByNameAndCategoriaAndPrecoBase(
            nome, CategoriaEntityEnum.valueOf(categoria.name()), precoBase);
    if (seguroEntity != null) {
      var savedSeguro = modelMapper.map(seguroEntity, SeguroModel.class);
      log.info(
          "m=findByNameAndCategoriaAndPrecoBase msg=Final de encontrar seguro por nome: {}, categoria: {} e preço base: {}",
          nome,
          categoria.name(),
          precoBase);
      return savedSeguro;
    }
    return null;
  }
}
