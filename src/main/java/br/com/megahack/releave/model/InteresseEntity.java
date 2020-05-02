package br.com.megahack.releave.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "interesses")
public class InteresseEntity implements Serializable {
    @Id
    private String id;
    private String categoria;
    private UserEntity user;

}
