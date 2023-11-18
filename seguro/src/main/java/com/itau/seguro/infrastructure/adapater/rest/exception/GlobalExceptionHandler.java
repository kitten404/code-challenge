package com.itau.seguro.infrastructure.adapater.rest.exception;

import static com.itau.seguro.domain.model.error.enums.DomainExceptionTypeEnum.GENERIC_EXCEPTION;

import com.itau.seguro.domain.model.error.DomainError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({RuntimeException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse genericException(Exception e) {
    return ErrorResponse.builder()
        .error(new DomainError(GENERIC_EXCEPTION, e.getMessage()))
        .build();
  }

  @ExceptionHandler({DomainError.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse genericException(DomainError e) {
    return ErrorResponse.builder().error(new DomainError(e.getErrorType(), e.getMessage())).build();
  }
}
