package br.com.megahack.releave.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_sequence")
  @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;
}
