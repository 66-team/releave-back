package br.com.megahack.releave.service;

import br.com.megahack.releave.model.Company;
import br.com.megahack.releave.model.Product;
import br.com.megahack.releave.model.ProductStorage;
import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.ProductReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.model.dto.request.ProductRequestDto;
import br.com.megahack.releave.repository.ProductRepository;
import br.com.megahack.releave.service.exception.ObjectNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

  private final ProductRepository productRepository;
  private final UserService userService;
  private final CompanyService companyService;
  private final ProductStorageService productStorageService;

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public Product findById(String id) {
    return productRepository.findById(id).orElseThrow(
        () -> new ObjectNotFoundException(String.format("Product id %s not found.", id)));
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public ProductStorage saveRequest(ProductRequestDto dto) {
    Product product = new Product(dto);
    Company company = companyService.findById(dto.getIdCompany());
    User user = userService.findById(dto.getIdUser());

    companyService.validCompanyUser(company,user);

    product.setRegisteredByUser(new UserReferenceDto(user));
    product.setCompany(new CompanyReferenceDto(company));
    productRepository.save(product);
    ProductStorage productStorage = productStorageService.save(
        new ProductStorage(new ProductReferenceDto(product), dto.getPrice(), dto.getQuantity(),
            dto.getReferenceStorage()));

    product.getStorage().add(productStorage);
    this.save(product);
    return productStorage;
  }

}
