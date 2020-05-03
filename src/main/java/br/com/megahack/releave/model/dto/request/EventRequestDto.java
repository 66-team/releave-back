package br.com.megahack.releave.model.dto.request;

import br.com.megahack.releave.annotation.EventInsert;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@EventInsert
public class EventRequestDto implements Serializable {

  @NotBlank
  private String name;
  @NotBlank
  private String description;
  @NotNull
  private LocalDateTime startDate;
  @NotNull
  private LocalDateTime endDate;
  @NotBlank
  private String streamUrl;
  @NotBlank
  private String companyId;
  @NotBlank
  private String userId;

}
