package br.com.megahack.releave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ReleaveApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReleaveApplication.class, args);
  }

}
