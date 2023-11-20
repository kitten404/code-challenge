package com.itau.seguro.infrastructure.adapater.rest.exception;

import static com.itau.seguro.domain.model.error.enums.DomainExceptionTypeEnum.*;

import com.itau.seguro.domain.model.error.DomainError;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        .errors(List.of(new Error(GENERIC_EXCEPTION.name(), e.getMessage())))
        .build();
  }

  @ExceptionHandler({DomainError.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse genericException(DomainError e) {
    return ErrorResponse.builder()
        .errors(List.of(new Error(e.getErrorType().name(), e.getMessage())))
        .build();
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse badRequestException(MethodArgumentNotValidException e) {
    var errorResponse =
        e.getBindingResult().getFieldErrors().stream()
            .map(
                it ->
                    new Error(
                        DADO_INVALIDO_EXCEPTION.name(),
                        it.getDefaultMessage() + " em " + it.getField()))
            .toList();
    return new ErrorResponse(errorResponse);
  }
}
