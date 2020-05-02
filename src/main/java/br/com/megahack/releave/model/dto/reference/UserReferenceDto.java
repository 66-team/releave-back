package br.com.megahack.releave.model.dto.reference;

import br.com.megahack.releave.model.User;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReferenceDto implements Serializable {

  private String id;
  private String name;
  private String cpf;

  public UserReferenceDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.cpf = user.getCpf();
  }
}
