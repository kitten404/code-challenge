package com.itau.seguro.domain.exception;

public class PersistenceException extends RuntimeException {
  public PersistenceException(String msg) {
    super(msg);
  }

  public PersistenceException() {
    super();
  }
}
