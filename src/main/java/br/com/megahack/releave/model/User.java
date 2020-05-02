package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "users")
public class User implements Serializable {

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
  private List<CompanyReferenceDto> companyOwner = new ArrayList<>();
  private List<CompanyReferenceDto> companiesEmployer = new ArrayList<>();

  public enum Gender{
    MAN, WOMAN
  }
  public enum UserType{
     USER, PROVIDER
  }

  public User(){
    this.createdDate = LocalDateTime.now();
  }

}
