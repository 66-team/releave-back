package br.com.megahack.releave.service;

import br.com.megahack.releave.model.UserEntity;
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

  public UserEntity save(UserEntity user) {
    return userRepository.save(user);
  }

  public List<UserEntity> findAll() {
    return userRepository.findAll();
  }

  public UserEntity findById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(
            () -> new ObjectNotFoundException(String.format("User id %s not found.", id)));
  }

  public UserResponseDto toDto(UserEntity userEntity) {
    UserResponseDto user = new UserResponseDto();
    user.setId(userEntity.getId());
    user.setName(userEntity.getName());
    return user;
  }

  public UserEntity toEntity(UserRequestDto userRequestDto) {
    UserEntity userEntity = new UserEntity();
    userEntity.setName(userRequestDto.getName());
    return userEntity;
  }

}
