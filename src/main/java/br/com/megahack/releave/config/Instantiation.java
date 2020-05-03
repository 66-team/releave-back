package br.com.megahack.releave.config;

import br.com.megahack.releave.model.Company;
import br.com.megahack.releave.model.Event;
import br.com.megahack.releave.model.Product;
import br.com.megahack.releave.model.ProductStorage;
import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.User.Gender;
import br.com.megahack.releave.model.User.UserType;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.ProductReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.repository.CompanyRepository;
import br.com.megahack.releave.repository.EventRepository;
import br.com.megahack.releave.repository.ProductRepository;
import br.com.megahack.releave.repository.ProductStorageRepository;
import br.com.megahack.releave.repository.UserRepository;
import com.google.common.collect.Sets;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Instantiation implements CommandLineRunner {


  private final UserRepository userRepository;
  private final CompanyRepository companyRepository;
  private final ProductRepository productRepository;
  private final EventRepository eventRepository;
  private final ProductStorageRepository productStorageRepository;


  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();
    companyRepository.deleteAll();
    productRepository.deleteAll();
    eventRepository.deleteAll();
    productRepository.deleteAll();
    productStorageRepository.deleteAll();

    User almir = new User("Almir", "12345678909", LocalDate.of(1994, 2, 19), Gender.MAN,
        UserType.CUSTOMER, null, "1234", null, null);
    User renan = new User("Renan", "66742956046", LocalDate.of(1995, 2, 16), Gender.WOMAN,
        UserType.SELLER, null, "1234", null, null);

    userRepository.saveAll(Arrays.asList(almir, renan));

    Company company = new Company("37809009000158", "Tey LTDA", new UserReferenceDto(almir));
    company.getEmployees().add(renan);
    companyRepository.save(company);

    almir.setCompanyOwner(Stream.of(company).map(CompanyReferenceDto::new).collect(
        Collectors.toList()));
    renan.setEmployerCompanies(Stream.of(company).map(CompanyReferenceDto::new).collect(
        Collectors.toList()));

    userRepository.saveAll(Arrays.asList(almir, renan));

    Product product = new Product("Camisa", "Cor branca", "Adidas","REF1234",
        Sets.newHashSet("www.uol.com.br", "www.bol.com.br"),
        new CompanyReferenceDto(company), new UserReferenceDto(renan));
    productRepository.save(product);

    ProductStorage productStorage = new ProductStorage(new ProductReferenceDto(product), BigDecimal.valueOf(10.50D), 25, "REF342523");
    productStorageRepository.save(productStorage);

    product.getStorage().add(productStorage);
    productRepository.save(product);

    company.getProducts().add(product);
    companyRepository.save(company);

    Event event = new Event("Novo Livro Paulo Coelho", "Livro blá blá blá",
        LocalDateTime.of(2020, 2, 1, 20, 30), LocalDateTime.of(2020, 2, 1, 21, 30),
        Collections.singletonList(product), "www.youtube.com", new CompanyReferenceDto(company),
        new UserReferenceDto(renan), false);
    eventRepository.save(event);


  }
}
