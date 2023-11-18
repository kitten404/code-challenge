package com.itau.seguro.domain.model.error;

import com.itau.seguro.domain.model.error.enums.DomainExceptionTypeEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainError extends RuntimeException {
  private DomainExceptionTypeEnum errorType;
  private String message;

  public DomainError(DomainExceptionTypeEnum errorType, String message) {
    super(message);
    this.errorType = errorType;
  }
}
