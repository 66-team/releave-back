package br.com.megahack.releave.repository;

import br.com.megahack.releave.model.ProductStorage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStorageRepository extends MongoRepository<ProductStorage,String> {

}
