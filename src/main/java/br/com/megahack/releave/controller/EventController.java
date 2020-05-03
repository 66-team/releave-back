package br.com.megahack.releave.controller;

import br.com.megahack.releave.model.Event;
import br.com.megahack.releave.model.dto.request.EventRequestDto;
import br.com.megahack.releave.model.dto.response.IdResponse;
import br.com.megahack.releave.service.EventService;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/event")
public class EventController {

  private final EventService eventService;

  @PostMapping
  private ResponseEntity<IdResponse> save(@RequestBody @Valid EventRequestDto eventRequestDto) {
    Event event = eventService.saveRequest(eventRequestDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(event.getId())
        .toUri();
    return ResponseEntity.created(uri).body(new IdResponse(event.getId()));
  }

}
