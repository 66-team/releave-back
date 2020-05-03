package br.com.megahack.releave.annotation;


import br.com.megahack.releave.controller.exception.FieldMessage;
import br.com.megahack.releave.model.User.UserType;
import br.com.megahack.releave.model.dto.request.UserRequestDto;
import br.com.megahack.releave.service.CompanyService;
import br.com.megahack.releave.service.UserService;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import br.com.megahack.releave.utils.BRUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UserInsertValidator implements ConstraintValidator<UserInsert, UserRequestDto> {

  @Autowired
  private UserService userService;
  @Autowired
  private CompanyService companyService;

  @Override
  public void initialize(UserInsert ann) {
    //nothing
  }

  @Override
  public boolean isValid(UserRequestDto objDto, ConstraintValidatorContext context) {
    List<FieldMessage> list = new ArrayList<>();

    if (!BRUtil.isValidCPF(objDto.getCpf())) {
      list.add(new FieldMessage("cpf", "cpf invalid"));
    } else {
      try {
        userService.findByCpf(objDto.getCpf());
        list.add(
            new FieldMessage("cpf", String.format("cpf %s already registered", objDto.getCpf())));
      } catch (ObjectNotFoundException ignored) {
        //nothing
      }
    }

    if (objDto.getBirthday() == null || objDto.getBirthday().isAfter(LocalDate.now())) {
      list.add(new FieldMessage("birthday", "date invalid"));
    }

    this.validCompany(objDto, list);

    for (FieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
          .addConstraintViolation();
    }
    return list.isEmpty();
  }

  private void validCompany(UserRequestDto objDto, List<FieldMessage> list) {
    if (UserType.SELLER.equals(objDto.getType())) {
      if (!StringUtils.hasText(objDto.getFantasyName())) {
        list.add(new FieldMessage("fantasyName", "must not be null"));
      }
      if (!BRUtil.isValidCNPJ(objDto.getCnpj())) {
        list.add(new FieldMessage("cnpj", "cnpj invalid"));
      } else {
        try {
          companyService.findByCnpj(objDto.getCnpj());
          list.add(new FieldMessage("cnpj",
              String.format("cnpj %s already registered", objDto.getCnpj())));
        } catch (ObjectNotFoundException ignored) {
          //nothing
        }
      }
    }
  }

}
