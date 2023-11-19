package com.itau.seguro.infrastructure.adapater.rest;

import com.itau.seguro.application.usecase.UpdateSeguroUseCase;
import com.itau.seguro.domain.model.SeguroModel;
import com.itau.seguro.infrastructure.adapater.rest.dto.request.SeguroV1Request;
import com.itau.seguro.infrastructure.adapater.rest.dto.response.SeguroV1Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/seguros")
@AllArgsConstructor
@Slf4j
public class SeguroController {
  private UpdateSeguroUseCase updateSeguroUseCase;
  private ModelMapper modelMapper;

  @PostMapping
  public SeguroV1Response updateSeguro(@RequestBody SeguroV1Request request) {
    var response = updateSeguroUseCase.execute(modelMapper.map(request, SeguroModel.class));
    return modelMapper.map(response, SeguroV1Response.class);
  }
}
