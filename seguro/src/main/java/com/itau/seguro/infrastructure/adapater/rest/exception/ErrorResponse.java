package com.itau.seguro.infrastructure.adapater.rest.exception;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
  private List<Error> errors;
}
