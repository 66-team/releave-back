package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractModel {

  private String name;
  private String describe;
  private String brand;
  private BigDecimal price;
  private Set<String> imagesUrl = new HashSet<>();
  private CompanyReferenceDto company;
  private Integer quantity;
  private UserReferenceDto registeredByUser;
}
