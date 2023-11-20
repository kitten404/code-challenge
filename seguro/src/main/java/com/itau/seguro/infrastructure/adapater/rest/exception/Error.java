package com.itau.seguro.infrastructure.adapater.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
  private String errorType;
  private String message;
}
