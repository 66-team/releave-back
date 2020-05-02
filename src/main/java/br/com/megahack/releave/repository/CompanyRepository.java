package br.com.megahack.releave.repository;

import br.com.megahack.releave.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company,String> {

}