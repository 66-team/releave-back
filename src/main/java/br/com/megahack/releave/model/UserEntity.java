package br.com.megahack.releave.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "users")
public class UserEntity implements Serializable {

  @Id
  private String id;
  private String name;
  private String cpf;
  private LocalDate birthday;
  private Gender gender;
  private UserType type;
  private String photoUrl;
  private String password;
  private LocalDateTime createdDate;

  private enum Gender{
    MAN, WOMAN
  }
  private enum UserType{
     USER, PROVIDER
  }

  public UserEntity (){
    this.createdDate = LocalDateTime.now();
  }

}
