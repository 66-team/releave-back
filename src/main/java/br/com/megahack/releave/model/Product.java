package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.model.dto.request.ProductRequestDto;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractModel {

  private String name;
  private String describe;
  private String brand;
  private String referenceSeller;
  private Set<String> imagesUrl = new HashSet<>();
  private CompanyReferenceDto company;
  private UserReferenceDto registeredByUser;
  @DBRef(lazy = true)
  private Set<ProductStorage> storage = new HashSet<>();

  public Product(String name, String describe, String brand, String referenceSeller,
      Set<String> imagesUrl, CompanyReferenceDto company,
      UserReferenceDto registeredByUser) {
    this.name = name;
    this.describe = describe;
    this.brand = brand;
    this.referenceSeller = referenceSeller;
    this.imagesUrl = imagesUrl;
    this.company = company;
    this.registeredByUser = registeredByUser;
  }

  public Product(ProductRequestDto dto){
    this.name = dto.getName();
    this.describe = dto.getDescribe();
    this.brand = dto.getBrand();
    this.referenceSeller = dto.getReferenceProduct();
    this.imagesUrl = dto.getImagesUrl();
  }

}
