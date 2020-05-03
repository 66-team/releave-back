package br.com.megahack.releave.repository;

import br.com.megahack.releave.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  List<User> findAll();
  Optional<User> findByCpf(String cpf);
}
