package br.com.megahack.releave.model.dto.response;

import br.com.megahack.releave.model.Event;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDto implements Serializable {

  private String id;
  private String name;
  private String description;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String streamUrl;
  private CompanyReferenceDto company;

  public EventResponseDto(Event event) {

    this.id = event.getId();
    this.name = event.getName();
    this.description = event.getDescription();
    this.startDate = event.getStartDate();
    this.endDate = event.getEndDate();
    this.streamUrl = event.getStreamUrl();
    this.company = event.getCompany();
  }
}
