package br.com.megahack.releave.service;

import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.dto.response.UserResponseDto;
import br.com.megahack.releave.repository.UserRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
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

  public User findByCpf(String cpf) {
    return userRepository.findByCpf(cpf).orElseThrow(
        () -> new ObjectNotFoundException(String.format("User cpf %s not found.", cpf)));
  }

  public UserResponseDto toDto(User userEntity) {
    UserResponseDto user = new UserResponseDto();
    user.setId(userEntity.getId());
    user.setName(userEntity.getName());
    user.setBirthday(userEntity.getBirthday());
    user.setCompanyOwner(userEntity.getCompanyOwner());
    user.setEmail(userEntity.getEmail());
    user.setGender(userEntity.getGender());
    user.setType(userEntity.getType());
    user.setEmployerCompanies(userEntity.getEmployerCompanies());
    user.setCpf(userEntity.getCpf());
    user.setPhotoUrl(userEntity.getPhotoUrl());
    return user;
  }

}
