package br.com.axe.peopleapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String cpf;
    private List<PhoneRequest> phones;
}
