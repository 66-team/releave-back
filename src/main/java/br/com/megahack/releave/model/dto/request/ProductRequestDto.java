package br.com.megahack.releave.model.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto implements Serializable {

  @NotBlank
  private String name;
  @NotBlank
  private String describe;
  @NotBlank
  private String brand;

  private String referenceProduct;
  @NotEmpty
  private Set<String> imagesUrl = new HashSet<>();
  @NotBlank
  private String idCompany;
  @NotBlank
  private String idUser;

  private String referenceStorage;

  @NotNull
  private Integer quantity;
  @NotNull
  private BigDecimal price;

}
