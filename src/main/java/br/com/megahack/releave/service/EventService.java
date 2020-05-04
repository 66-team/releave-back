package br.com.megahack.releave.service;

import br.com.megahack.releave.model.Event;
import br.com.megahack.releave.model.ProductStorage;
import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.ProductStorageReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.model.dto.request.EventProductRequestDto;
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
  private final ProductStorageService productStorageService;

  public Event save(Event event) {
    return eventRepository.save(event);
  }

  public Event saveRequest(EventRequestDto eventRequestDto) {
    Event event = new Event(eventRequestDto);
    User user = userService.findById(eventRequestDto.getUserId());

    companyService.validCompanyUser(companyService.findById(event.getCompany().getId()), user);

    event.setEmployer(new UserReferenceDto(user));
    event.setCompany(
        new CompanyReferenceDto(companyService.findById(eventRequestDto.getCompanyId())));

    return this.save(event);
  }

  public Event findById(String id) {
    return eventRepository.findById(id)
        .orElseThrow(
            () -> new ObjectNotFoundException(String.format("Event id %s not found.", id)));
  }

  public List<Event> findAll() {
    return eventRepository.findAll();
  }

  public Event addProduct(EventProductRequestDto dto) {
    User user = userService.findById(dto.getIdUser());
    ProductStorage productStorage = productStorageService.findById(dto.getIdProductStorage());
    Event event = this.findById(dto.getIdEvent());

    if (!event.getCompany().getId().equals(productStorage.getProduct().getCompany().getId())) {
      throw new IllegalArgumentException("Product is not associated with event company.");
    }

    companyService.validCompanyUser(companyService.findById(event.getCompany().getId()), user);

    event.getProductsStorage().add(new ProductStorageReferenceDto(productStorage));
    return this.save(event);

  }

}
