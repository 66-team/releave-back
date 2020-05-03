package br.com.megahack.releave.model;

import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.ProductStorageReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractModel {

  private String name;
  private String description;
  private LocalDateTime start;
  private LocalDateTime end;
  private List<ProductStorageReferenceDto> productsStorage = new ArrayList<>();
  private String streamUrl;
  private CompanyReferenceDto company;
  private UserReferenceDto employer;
  private boolean ended;
}
