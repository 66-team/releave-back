package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.ProductStorageReferenceDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "purchase")
public class Purchase extends AbstractModel {

  private Event event;
  private List<ProductStorageReferenceDto> products;

}
