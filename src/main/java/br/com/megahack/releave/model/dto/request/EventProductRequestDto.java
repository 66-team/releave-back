package br.com.megahack.releave.model.dto.request;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventProductRequestDto implements Serializable {

  @NotBlank
  private String idProductStorage;
  @NotBlank
  private String idUser;
  @NotBlank
  private String idEvent;
}
