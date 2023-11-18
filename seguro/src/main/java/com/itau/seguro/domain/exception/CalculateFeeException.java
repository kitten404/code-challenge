package com.itau.seguro.domain.exception;

import static com.itau.seguro.domain.model.error.enums.DomainExceptionTypeEnum.CALCULATE_FEE_EXCEPTION;

import com.itau.seguro.domain.model.error.DomainError;

public class CalculateFeeException extends DomainError {
  public CalculateFeeException(String msg) {
    super(CALCULATE_FEE_EXCEPTION, msg);
  }
}
