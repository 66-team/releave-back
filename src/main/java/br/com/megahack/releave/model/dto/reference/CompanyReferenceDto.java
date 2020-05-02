package br.com.megahack.releave.model.dto.reference;

import br.com.megahack.releave.model.Company;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyReferenceDto implements Serializable {

  private String id;
  private String cnpj;
  private String fantasyName;

  public CompanyReferenceDto (Company company){
    this.id = company.getId();
    this.cnpj = company.getCnpj();
    this.fantasyName = company.getFantasyName();
  }
}
