package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.request.UserRequestDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User extends AbstractModel {

  private String name;
  private String cpf;
  private LocalDate birthday;
  private String email;
  private Gender gender;
  private UserType type;
  private String photoUrl;
  private String password;
  private List<CompanyReferenceDto> companyOwner = new ArrayList<>();
  private List<CompanyReferenceDto> employerCompanies = new ArrayList<>();
  private boolean disable;

  public enum Gender{
    MAN, WOMAN
  }
  public enum UserType{
    CUSTOMER, SELLER
  }

  public User(UserRequestDto userRequestDto) {
    super();
    this.name = userRequestDto.getName();
    this.cpf = userRequestDto.getCpf().replaceAll("\\D", "");
    this.birthday = userRequestDto.getBirthday();
    this.type = userRequestDto.getType();
    this.password = userRequestDto.getPassword();
    this.email = userRequestDto.getEmail();
  }
}
