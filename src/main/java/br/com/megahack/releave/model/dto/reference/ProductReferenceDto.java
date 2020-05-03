package br.com.megahack.releave.model.dto.reference;

import br.com.megahack.releave.model.Product;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class ProductReferenceDto implements Serializable {
  private String id;
  private String name;
  private String describe;
  private String brand;
  private String referenceSeller;
  private Set<String> imagesUrl = new HashSet<>();
  private CompanyReferenceDto company;
  private UserReferenceDto registeredByUser;

  public ProductReferenceDto(Product product){
    this.id = product.getId();
    this.name = product.getName();
    this.describe = product.getDescribe();
    this.brand = product.getBrand();
    this.referenceSeller = product.getReferenceSeller();
    this.imagesUrl = product.getImagesUrl();
    this.company = product.getCompany();
    this.registeredByUser = product.getRegisteredByUser();
  }


}
