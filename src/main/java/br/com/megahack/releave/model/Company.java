package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "company")
public class Company implements Serializable {

  private String id;
  private String cnpj;
  private String fantasyName;
  private UserReferenceDto owner;
  @DBRef(lazy = true)
  private List<User> employees = new ArrayList<>();
  private LocalDateTime createdDate;


  public Company (){
    this.createdDate = LocalDateTime.now();
  }


}
