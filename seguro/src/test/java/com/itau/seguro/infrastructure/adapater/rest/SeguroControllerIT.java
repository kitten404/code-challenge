package com.itau.seguro.infrastructure.adapater.rest;

import static com.itau.seguro.mock.SeguroV1RequestMock.createSeguroV1RequestMock;
import static org.junit.jupiter.api.Assertions.*;

import com.itau.seguro.IntegrationTests;
import com.itau.seguro.infrastructure.adapater.persistence.SeguroRepository;
import com.itau.seguro.infrastructure.adapater.rest.dto.response.SeguroV1Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

class SeguroControllerIT extends IntegrationTests {
  @Autowired private SeguroRepository seguroRepository;
  @Autowired private TestRestTemplate restTemplate;

  private String baseUri;

  @LocalServerPort private String PORT;

  @BeforeEach
  public void setUp() {
    baseUri = "http://localhost:" + PORT;
  }

  @Test
  public void deveSalvarSeguroInexistente() {
    var request = createSeguroV1RequestMock();

    var response =
        restTemplate.postForEntity(baseUri + "/v1/seguros", request, SeguroV1Response.class);

    assertEquals(200, response.getStatusCode().value());
    var salvoSeguro = seguroRepository.findAll();
    assertEquals(1, salvoSeguro.size());
  }
}
