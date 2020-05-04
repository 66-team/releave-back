package br.com.megahack.releave.controller;

import static java.util.stream.Collectors.toList;

import br.com.megahack.releave.model.Event;
import br.com.megahack.releave.model.dto.request.EventProductRequestDto;
import br.com.megahack.releave.model.dto.request.EventRequestDto;
import br.com.megahack.releave.model.dto.response.EventResponseDto;
import br.com.megahack.releave.model.dto.response.IdResponse;
import br.com.megahack.releave.service.EventService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<IdResponse> save(@RequestBody @Valid EventRequestDto eventRequestDto) {
    Event event = eventService.saveRequest(eventRequestDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(event.getId())
        .toUri();
    return ResponseEntity.created(uri).body(new IdResponse(event.getId()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Event> findById(@PathVariable("id") String id) {
    return ResponseEntity.ok(eventService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<EventResponseDto>> findAll() {
    return ResponseEntity
        .ok(eventService.findAll().stream().map(EventResponseDto::new).collect(toList()));
  }

  @PostMapping("/add-product")
  public ResponseEntity<Event> addProduct(
      @RequestBody @Valid EventProductRequestDto eventProductRequestDto) {
    return ResponseEntity.ok().body(eventService.addProduct(eventProductRequestDto));
  }

}
