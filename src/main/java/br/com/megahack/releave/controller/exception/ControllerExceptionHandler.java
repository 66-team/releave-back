package br.com.megahack.releave.controller.exception;

import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
      HttpServletRequest request) {

    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
        HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
      HttpServletRequest request) {

    ValidationError err = new ValidationError(System.currentTimeMillis(),
        HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validação", "Campos inválidos",
        request.getRequestURI());

    e.getBindingResult().getFieldErrors()
        .forEach(x -> err.addError(x.getField(), x.getDefaultMessage()));
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e,
      HttpServletRequest request) {

    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }


}
