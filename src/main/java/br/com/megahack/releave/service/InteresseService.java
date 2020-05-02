package br.com.megahack.releave.service;

import br.com.megahack.releave.model.InteresseEntity;
import br.com.megahack.releave.model.dto.request.InteresseRequestDto;
import br.com.megahack.releave.model.dto.response.InteresseResponseDto;
import br.com.megahack.releave.repository.InteresseRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InteresseService {

  private final InteresseRepository interesseRepository;

  public InteresseEntity save(InteresseEntity interesse) {
    return interesseRepository.save(interesse);
  }

  public List<InteresseEntity> findAll() {
    return interesseRepository.findAll();
  }

  public InteresseEntity findById(String id) {

    return interesseRepository.findById(id)
        .orElseThrow(
            () -> new ObjectNotFoundException(String.format("Interesse id %s not found.", id)));

  }

  //TODO ACRESCENTAR OS NOVOS ATRIBUTOS P/ CONVERSÃO

  public InteresseResponseDto toDto(InteresseEntity interesseEntity) {

    InteresseResponseDto interesse = new InteresseResponseDto();
    interesse.setId(interesseEntity.getId());
    interesse.setCategoria(interesseEntity.getCategoria());
    return interesse;

  }

  public InteresseEntity toEntity(InteresseRequestDto interesseRequestDto) {

    InteresseEntity interesse = new InteresseEntity();
    interesse.setCategoria(interesseRequestDto.getCategoria());
    return interesse;

  }

}
