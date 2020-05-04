package br.com.megahack.releave.service;

import br.com.megahack.releave.model.Product;
import br.com.megahack.releave.model.ProductStorage;
import br.com.megahack.releave.repository.ProductStorageRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductStorageService {

  private final ProductStorageRepository productStorageRepository;

  public ProductStorage save(ProductStorage productStorage){
    return productStorageRepository.save(productStorage);
  }

  public ProductStorage findById(String id) {
    return productStorageRepository.findById(id).orElseThrow(
        () -> new ObjectNotFoundException(String.format("Product id %s not found.", id)));
  }

  public List<ProductStorage> findAll(){
    return productStorageRepository.findAll();
  }
}
