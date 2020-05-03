package br.com.megahack.releave.service;

import br.com.megahack.releave.model.Company;
import br.com.megahack.releave.repository.CompanyRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {

  private final CompanyRepository companyRepository;

  public Company findByCnpj(String cnpj){
    return companyRepository.findByCnpj(cnpj).orElseThrow(
        () -> new ObjectNotFoundException(String.format("Company cnpj %s not found.", cnpj)));
  }

  public Company findById(String id){
    return companyRepository.findById(id).orElseThrow(
        () -> new ObjectNotFoundException(String.format("Company id %s not found.", id)));
  }

  public Company save(Company company){
    return companyRepository.save(company);
  }

}
