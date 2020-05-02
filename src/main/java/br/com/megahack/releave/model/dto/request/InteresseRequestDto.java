package br.com.megahack.releave.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteresseRequestDto implements Serializable {

    //TODO ACRESCENTAR NOVOS ATRIBUTOS DE INTERESSE

    @NotBlank
    @Size(min = 3, max = 30)
    private String categoria;

}
