package br.com.megahack.releave.model.dto.response;

import br.com.megahack.releave.model.User.Gender;
import br.com.megahack.releave.model.User.UserType;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto implements Serializable {

  private String id;
  private String name;
  private String cpf;
  private LocalDate birthday;
  private String email;
  private Gender gender;
  private UserType type;
  private String photoUrl;
  private List<CompanyReferenceDto> companyOwner = new ArrayList<>();
  private List<CompanyReferenceDto> employerCompanies = new ArrayList<>();

}
