package br.com.axe.peopleapi.dto.request;

import br.com.axe.peopleapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequest {
    @Enumerated(EnumType.STRING)
    private PhoneType type;
    @NotEmpty
    @Size(min= 10, max=14)
    private String number;
}
