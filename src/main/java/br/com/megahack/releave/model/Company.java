package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "company")
public class Company extends AbstractModel {

  private String cnpj;
  private String fantasyName;
  private UserReferenceDto userOwner;
  @DBRef(lazy = true)
  private List<User> employees = new ArrayList<>();
  @DBRef(lazy = true)
  private List<Product> products = new ArrayList<>();
  @DBRef(lazy = true)
  private List<ProductStorage> storage = new ArrayList<>();

  public Company(String cnpj, String fantasyName,
      UserReferenceDto owner) {
    super();
    this.cnpj = cnpj;
    this.fantasyName = fantasyName;
    this.userOwner = owner;
  }

}
