package br.com.megahack.releave.service;

import br.com.megahack.releave.model.Event;
import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.model.dto.request.EventRequestDto;
import br.com.megahack.releave.repository.EventRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventService {

  private final EventRepository eventRepository;
  private final UserService userService;
  private final CompanyService companyService;

  public Event save(Event event) {
    return eventRepository.save(event);
  }

  public Event saveRequest(EventRequestDto eventRequestDto) {
    Event event = new Event(eventRequestDto);
    User user = userService.findById(eventRequestDto.getUserId());
    boolean isEmployer = user.getEmployerCompanies().stream()
        .anyMatch(e -> eventRequestDto.getCompanyId().equalsIgnoreCase(e.getId()));
    boolean isOwner = user.getCompanyOwner().stream()
        .anyMatch(e -> eventRequestDto.getCompanyId().equalsIgnoreCase(e.getId()));

    if (!isEmployer && !isOwner) {
      throw new IllegalArgumentException("User is not associated to company.");
    }
    event.setEmployer(new UserReferenceDto(user));
    event.setCompany(
        new CompanyReferenceDto(companyService.findById(eventRequestDto.getCompanyId())));

    return this.save(event);
  }

  public Event findById(String id){
    return eventRepository.findById(id)
        .orElseThrow(
            () -> new ObjectNotFoundException(String.format("Event id %s not found.", id)));
  }

  public List<Event> findAll(){
    return eventRepository.findAll();
  }

}
