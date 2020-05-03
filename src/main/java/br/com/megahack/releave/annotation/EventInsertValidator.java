package br.com.megahack.releave.annotation;

import br.com.megahack.releave.controller.exception.FieldMessage;
import br.com.megahack.releave.model.dto.request.EventRequestDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EventInsertValidator implements ConstraintValidator<EventInsert, EventRequestDto> {

  @Override
  public void initialize(EventInsert ann) {
    //nothing
  }

  @Override
  public boolean isValid(EventRequestDto objDto, ConstraintValidatorContext context) {
    List<FieldMessage> list = new ArrayList<>();

    if (objDto.getStartDate() == null || objDto.getStartDate().isBefore(LocalDateTime.now())) {
      list.add(new FieldMessage("startDate", "should be greater than now"));
    }
    if (objDto.getEndDate() == null || objDto.getEndDate().isBefore(objDto.getStartDate())) {
      list.add(new FieldMessage("endDate", "should be greater than startDate"));
    }


    for (FieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
          .addConstraintViolation();
    }
    return list.isEmpty();
  }
}
