package br.com.megahack.releave.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.data.annotation.CreatedDate;
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
