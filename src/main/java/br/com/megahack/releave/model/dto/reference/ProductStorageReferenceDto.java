package br.com.megahack.releave.model.dto.reference;

import br.com.megahack.releave.model.Product;
import br.com.megahack.releave.model.ProductStorage;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStorageReferenceDto implements Serializable {

  private String id;
  private String name;
  private Set<String> imagesUrl = new HashSet<>();
  private String idStorage;
  private BigDecimal price;
  private String describe;
  private Integer quantity;

  public ProductStorageReferenceDto(@NotNull ProductStorage productStorage) {
    this.id = productStorage.getProduct().getId();
    this.name = productStorage.getProduct().getName();
    this.describe = productStorage.getProduct().getDescribe();
    this.imagesUrl = productStorage.getProduct().getImagesUrl();
    this.idStorage = productStorage.getId();
    this.price = productStorage.getPrice();
    this.quantity = productStorage.getQuantity();
  }

}
