package com.itau.seguro.infrastructure.adapater.persistence;

import static com.itau.seguro.mock.SeguroEntityMock.createSeguroEntityMock;
import static com.itau.seguro.mock.SeguroModelMock.createSeguroModelMock;
import static org.junit.jupiter.api.Assertions.*;

import com.itau.seguro.IntegrationTests;
import com.itau.seguro.domain.model.enums.CategoriaEnum;
import com.itau.seguro.infrastructure.adapater.persistence.entity.SeguroEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

class SeguroPersistenceAdapterIT extends IntegrationTests {

  private SeguroPersistenceAdapter seguroPersistenceAdapter;

  private ModelMapper modelMapper;

  @Autowired private SeguroRepository seguroRepository;

  @Autowired private TestEntityManager entityManager;

  @BeforeEach
  public void setUp() {
    modelMapper = new ModelMapper();
    seguroPersistenceAdapter = new SeguroPersistenceAdapter(seguroRepository, modelMapper);
  }

  @Test
  void deveSalvarSeguroComSucesso() {
    var seguroModel = createSeguroModelMock();

    var salvoSeguro = seguroPersistenceAdapter.save(seguroModel);

    assertNotNull(salvoSeguro.getId());
    assertEquals(seguroModel.getNome(), salvoSeguro.getNome());

    var entitySalva = entityManager.find(SeguroEntity.class, salvoSeguro.getId());
    assertNotNull(entitySalva);
  }

  @Test
  void deveEncontrarSeguroComSucesso() {
    var seguroEntity = createSeguroEntityMock();
    entityManager.persist(seguroEntity);

    var nome = seguroEntity.getNome();
    var categoria = CategoriaEnum.AUTO;
    var precoBase = seguroEntity.getPrecoBase();

    var seguroEncontrado =
        seguroPersistenceAdapter.findByNameAndCategoriaAndPrecoBase(nome, categoria, precoBase);

    assertNotNull(seguroEncontrado);
    assertEquals(nome, seguroEncontrado.getNome());
  }

  @Test
  void deveRetornarNuloQuandoNaoEncontrarSeguro() {
    var nome = "nome";
    var categoria = CategoriaEnum.AUTO;
    ;
    var precoBase = 100.0;

    var seguroEncontrado =
        seguroPersistenceAdapter.findByNameAndCategoriaAndPrecoBase(nome, categoria, precoBase);

    assertNull(seguroEncontrado);
  }
}
