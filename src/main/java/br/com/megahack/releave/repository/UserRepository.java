package br.com.megahack.releave.repository;

import br.com.megahack.releave.model.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

  List<UserEntity> findAll();

}
