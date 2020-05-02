package br.com.megahack.releave.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class AbstractModel implements Serializable {

  @Id
  private String id;
  private LocalDateTime createdDate;

  public AbstractModel(){
    this.createdDate = LocalDateTime.now();
  }

}
