package com.itau.seguro.domain.exception;

import static com.itau.seguro.domain.model.error.enums.DomainExceptionTypeEnum.PERSISTENCE_EXCEPTION;

import com.itau.seguro.domain.model.error.DomainError;

public class PersistenceException extends DomainError {
  public PersistenceException(String msg) {
    super(PERSISTENCE_EXCEPTION, msg);
  }
}
