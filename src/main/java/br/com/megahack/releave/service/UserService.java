package br.com.megahack.releave.service;

import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.dto.request.UserRequestDto;
import br.com.megahack.releave.model.dto.response.UserResponseDto;
import br.com.megahack.releave.repository.UserRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

  private final UserRepository userRepository;

  public User save(User user) {
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    return userRepository.findById(id)
        .orElseThrow(
            () -> new ObjectNotFoundException(String.format("User id %s not found.", id)));
  }

  public UserResponseDto toDto(User userEntity) {
    UserResponseDto user = new UserResponseDto();
    user.setId(userEntity.getId());
    user.setName(userEntity.getName());
    return user;
  }

  public User toEntity(UserRequestDto userRequestDto) {
    User user = new User();
    user.setName(userRequestDto.getName());
    return user;
  }

}
