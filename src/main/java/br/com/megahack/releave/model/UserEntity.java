package br.com.megahack.releave.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class UserEntity implements Serializable {

  @Id
  @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_sequence")
  private Long id;

  @Column(name = "name", nullable = false, length = 55)
  private String name;

  @OneToMany(mappedBy = "usuario")
  private InteresseEntity interesse;

}
