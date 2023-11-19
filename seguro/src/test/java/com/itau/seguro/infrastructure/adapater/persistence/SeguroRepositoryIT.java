package com.itau.seguro.infrastructure.adapater.persistence;

import static com.itau.seguro.mock.SeguroEntityMock.createSeguroEntityMock;
import static org.junit.jupiter.api.Assertions.*;

import com.itau.seguro.IntegrationTests;
import com.itau.seguro.infrastructure.adapater.persistence.entity.enums.CategoriaEntityEnum;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@Transactional
class SeguroRepositoryIT extends IntegrationTests {
  @Autowired private SeguroRepository seguroRepository;
  @Autowired private TestEntityManager entityManager;

  @Test
  void deveEncontrarByNomeCategoriaAndPrecoReposityComSucesso() {
    var seguroEntity = createSeguroEntityMock();
    entityManager.persist(seguroEntity);

    var nome = seguroEntity.getNome();
    var categoria = seguroEntity.getCategoria();
    var precoBase = seguroEntity.getPrecoBase();

    var seguroEncontrado =
        seguroRepository.findByNomeAndCategoriaAndPrecoBase(nome, categoria, precoBase);

    assertNotNull(seguroEncontrado);
    assertEquals(nome, seguroEncontrado.getNome());
    assertEquals(categoria, seguroEncontrado.getCategoria());
    assertEquals(precoBase, seguroEncontrado.getPrecoBase());
  }

  @Test
  void NaoDeveEncontrarByNomeCategoriaAndPrecoReposityComSucesso() {
    var nome = "nome";
    var categoria = CategoriaEntityEnum.AUTO;
    var precoBase = 100.0;

    var seguroEncontrado =
        seguroRepository.findByNomeAndCategoriaAndPrecoBase(nome, categoria, precoBase);

    assertNull(seguroEncontrado);
  }
}
