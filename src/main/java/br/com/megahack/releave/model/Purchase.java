package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.ProductStorageReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "purchase")
public class Purchase extends AbstractModel {

  private Event event;
  private Set<ProductPurchase> productPurchases = new HashSet<>();
  private UserReferenceDto user;
  private PaymentStatus paymentStatus;

  public enum PaymentStatus {
    WAITING, PROCESSING, DONE, ERROR
  }

  @Data
  @AllArgsConstructor
  public static class ProductPurchase implements Serializable {

    private ProductStorageReferenceDto productStorage;
    private Integer quantity;
  }
}
