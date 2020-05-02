package br.com.megahack.releave.controller;

import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.dto.request.UserRequestDto;
import br.com.megahack.releave.model.dto.response.UserResponseDto;
import br.com.megahack.releave.service.UserService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto userDto) {
    User user = userService.save(userService.toEntity(userDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(user.getId())
        .toUri();
    return ResponseEntity.created(uri).body(userService.toDto(user));
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDto>> findAll() {
    return ResponseEntity.ok(userService.findAll().stream()
        .map(userService::toDto)
        .collect(Collectors.toList()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDto> findById(@PathVariable("id") String id) {
    return ResponseEntity.ok(userService.toDto(userService.findById(id)));
  }

}
