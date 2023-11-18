package com.itau.seguro.infrastructure.adapater.rest.exception;

import com.itau.seguro.domain.model.error.DomainError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
  private DomainError error;
}
