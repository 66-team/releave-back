package br.com.megahack.releave.config;

import br.com.megahack.releave.model.Company;
import br.com.megahack.releave.model.User;
import br.com.megahack.releave.model.User.Gender;
import br.com.megahack.releave.model.User.UserType;
import br.com.megahack.releave.model.dto.reference.CompanyReferenceDto;
import br.com.megahack.releave.model.dto.reference.UserReferenceDto;
import br.com.megahack.releave.repository.CompanyRepository;
import br.com.megahack.releave.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
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


  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();
    companyRepository.deleteAll();

    User almir = new User(null, "Almir", "12345678909", LocalDate.of(1994, 2, 19), Gender.MAN,
        UserType.USER, null, "1234", LocalDateTime.now(), null, null);
    User renan = new User(null, "Renan", "66742956046", LocalDate.of(1995, 2, 16), Gender.MAN,
        UserType.USER, null, "1234", LocalDateTime.now(), null, null);

    userRepository.saveAll(Arrays.asList(almir, renan));

    Company cp1 = new Company(null, "37809009000158", "Tey LTDA", new UserReferenceDto(almir),
        Collections.singletonList(renan), LocalDateTime.now());
    companyRepository.save(cp1);

    almir.setCompanyOwner(Stream.of(cp1).map(CompanyReferenceDto::new).collect(
        Collectors.toList()));
    renan.setCompaniesEmployer(Stream.of(cp1).map(CompanyReferenceDto::new).collect(
        Collectors.toList()));

    userRepository.saveAll(Arrays.asList(almir, renan));



  }
}
