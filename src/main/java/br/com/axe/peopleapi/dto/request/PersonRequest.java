package br.com.axe.peopleapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {
    @NotEmpty
    @Size(min=3, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min=3, max = 100)
    private String lastName;
    private LocalDate birthDate;
    @NotEmpty
    @CPF
    private String cpf;
    @Valid
    @NotEmpty
    private List<PhoneRequest> phones;
}
