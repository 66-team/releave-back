package br.com.megahack.releave.model.dto.request;

import br.com.megahack.releave.annotation.UserInsert;
import br.com.megahack.releave.model.User.Gender;
import br.com.megahack.releave.model.User.UserType;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UserInsert
public class UserRequestDto implements Serializable {

  @NotBlank
  @Size(min = 3, max = 100)
  private String name;
  private String cpf;
  private LocalDate birthday;
  @NotNull
  private Gender gender;
  @NotNull
  private UserType type;
  @NotNull
  private String password;
  @Email
  @NotBlank
  private String email;

  private String fantasyName;
  private String cnpj;
}
