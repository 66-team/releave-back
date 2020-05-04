package br.com.megahack.releave.controller.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ValidationError extends StandardError {

  private final List<FieldMessage> erros = new ArrayList<>();

  public ValidationError(Long timestamp, Integer status, String error, String message,
      String path) {
    super(timestamp, status, error, message, path);
  }

  public List<FieldMessage> getErros() {
    return erros;
  }

  public void addError(String fieldName, String message) {
    erros.add(new FieldMessage(fieldName, message));
  }


}
