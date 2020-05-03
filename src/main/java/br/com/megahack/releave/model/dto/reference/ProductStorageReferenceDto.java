package br.com.megahack.releave.model.dto.reference;

import br.com.megahack.releave.model.Product;
import br.com.megahack.releave.model.ProductStorage;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductStorageReferenceDto implements Serializable {

  private String id;
  private String name;
  private String idStorage;
  private BigDecimal price;
  private String describe;
  private Integer quantity;

  public ProductStorageReferenceDto(@NotNull ProductStorage productStorage,@NotNull Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.describe = product.getDescribe();
    this.idStorage = productStorage.getId();
    this.price = productStorage.getPrice();
    this.quantity = productStorage.getQuantity();
  }

}
