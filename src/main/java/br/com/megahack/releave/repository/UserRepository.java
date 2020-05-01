package br.com.megahack.releave.repository;

import br.com.megahack.releave.model.UserEntity;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

  List<UserEntity> findAll();

}
