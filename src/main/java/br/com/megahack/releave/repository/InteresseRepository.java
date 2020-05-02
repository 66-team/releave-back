package br.com.megahack.releave.repository;

import br.com.megahack.releave.model.InteresseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteresseRepository extends PagingAndSortingRepository<InteresseEntity, String> {

    List<InteresseEntity> findAll();

    List<InteresseEntity> findByCategoriaContainingIgnoreCase(String categoria);

}
