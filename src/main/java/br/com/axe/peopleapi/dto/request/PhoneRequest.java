package br.com.axe.peopleapi.dto.request;

import br.com.axe.peopleapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequest {
    private PhoneType type;
    private String number;
}
