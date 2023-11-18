package com.itau.seguro.infrastructure.adapater.rest;

import static com.itau.seguro.mock.SeguroV1RequestMock.createSeguroV1RequestMock;
import static org.junit.jupiter.api.Assertions.*;

import com.itau.seguro.IntegrationTests;
import com.itau.seguro.infrastructure.adapater.persistence.SeguroRepository;
import com.itau.seguro.infrastructure.adapater.rest.dto.response.SeguroV1Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

class SeguroControllerIT extends IntegrationTests {
  private SeguroRepository seguroRepository;
  private RestTemplate restTemplate;

  private String baseUri;

  @LocalServerPort private String PORT;

  @BeforeEach
  public void setUp() {
    restTemplate = new RestTemplate();
    baseUri = "http://localhost:" + PORT;
  }

  @Test
  public void deveSalvarSeguroInexistente() {
    var request = createSeguroV1RequestMock();

    var response =
        restTemplate.postForEntity(baseUri + "/v1/seguro", request, SeguroV1Response.class);

    assertEquals(response.getStatusCode(), 200);
    var salvoSeguro = seguroRepository.findAll();
    assertEquals(1, salvoSeguro.size());
  }
}
