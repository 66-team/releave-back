package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.ProductReferenceDto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product-storage")
public class ProductStorage extends AbstractModel{

  private ProductReferenceDto product;
  private BigDecimal price;
  private Integer quantity;
  private String referenceSeller;
}
