package br.com.megahack.releave.config;

import br.com.megahack.releave.model.Company;
import br.com.megahack.releave.model.Product;
import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.User.Gender;
import br.com.megahack.releave.model.User.UserType;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.repository.CompanyRepository;
import br.com.megahack.releave.repository.ProductRepository;
import br.com.megahack.releave.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
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


  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();
    companyRepository.deleteAll();
    productRepository.deleteAll();

    User almir = new User("Almir", "12345678909", LocalDate.of(1994, 2, 19), Gender.MAN,
        UserType.CUSTOMER, null, "1234", null, null);
    User renan = new User("Renan", "66742956046", LocalDate.of(1995, 2, 16), Gender.MAN,
        UserType.CUSTOMER, null, "1234", null, null);

    userRepository.saveAll(Arrays.asList(almir, renan));

    Company company = new Company("37809009000158", "Tey LTDA", new UserReferenceDto(almir));
    company.getEmployees().add(renan);
    companyRepository.save(company);

    almir.setCompanyOwner(Stream.of(company).map(CompanyReferenceDto::new).collect(
        Collectors.toList()));
    renan.setCompaniesEmployer(Stream.of(company).map(CompanyReferenceDto::new).collect(
        Collectors.toList()));

    userRepository.saveAll(Arrays.asList(almir, renan));

    Product product = new Product("Camisa branca","Adidas","www.uol.com.br",new CompanyReferenceDto(company),5, new UserReferenceDto(renan));
    productRepository.save(product);

    company.getProducts().add(product);
    companyRepository.save(company);


  }
}
