package br.com.megahack.releave.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "interesse")
public class InteresseEntity implements Serializable {

    //TODO ACRESCENTAR NOVOS ATRIBUTOS

    @Id
    @SequenceGenerator(name = "interesse_sequence", sequenceName = "interesse_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interesse_sequence")
    private Long id;

    @Column(name = "categoria", nullable = false, length = 30)
    private String categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity usuario;

}
